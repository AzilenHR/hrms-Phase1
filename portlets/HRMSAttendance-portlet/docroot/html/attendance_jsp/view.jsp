<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.hrms.service.EmployeeAttendanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="init.jsp"%>

<liferay-portlet:renderURL varImpl="attendanceSearchURL">
</liferay-portlet:renderURL>

<portlet:renderURL var="displayModeURL">
</portlet:renderURL>

<portlet:resourceURL var="myResourceURL">
	<portlet:param name="employeeSearchMode" value="true"/>
</portlet:resourceURL>

<aui:form method="post" action="<%=attendanceSearchURL%>"> 

	<liferay-portlet:renderURLParams varImpl="attendanceSearchURL" />
	
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="attendanceDisplayMode" value="<%=String.valueOf(attendanceDisplayMode) %>"/>
		<portlet:param name="employeeId" value="<%=String.valueOf(employeeId)%>"/>
		<portlet:param name="attendanceDate" value="<%=attendanceDate %>"/>
		<portlet:param name="attendanceQuarter" value="<%=attendanceQuarter %>"/>
		<portlet:param name="employeeName" value="<%=employeeName %>"/>
		<portlet:param name="attendanceMonth" value="<%=attendanceMonth %>"/>
	</liferay-portlet:renderURL>
	
		
	<% 	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy"),
		timeFormat = new SimpleDateFormat("hh:mm a");
		DecimalFormat df = new DecimalFormat("#####.##");
		User searchedUser = null;
	%>
	
	
	
	<div class="employee-attendance">
		<liferay-ui:search-container delta="30" deltaConfigurable="true" iteratorURL="<%=iteratorURL%>" 
			displayTerms="<%=new DisplayTerms(renderRequest)%>" emptyResultsMessage="No Attendance Found">
			<liferay-ui:search-form page="/html/attendance_jsp/AttendanceSearch.jsp" servletContext="<%=application %>" />
			<liferay-ui:search-container-results>
			<%
				DisplayTerms displayTerms = searchContainer.getDisplayTerms();
				String keywords = displayTerms.getKeywords();
				
				if(Validator.isNotNull(keywords) || Validator.isNotNull(employeeName))
				{
					searchedUser = UserLocalServiceUtil.getUser(employeeId);
				} else {
					searchedUser = themeDisplay.getUser();
				}
				
				int searchContainerStart = searchContainer.getStart(), 
						searchContainerEnd = searchContainer.getEnd();
								
				if(displayTerms.isAdvancedSearch() && attendanceDisplayMode > 0)
				{					
					switch(attendanceDisplayMode)
					{
					case 1:
						java.sql.Date sqlDate = new java.sql.Date(dateFormat.parse(attendanceDate).getTime());
						results = EmployeeAttendanceLocalServiceUtil.getAttendanceByDate(searchedUser, 
							sqlDate, searchContainerStart, searchContainerEnd);
						break;
					case 2:
						results = EmployeeAttendanceLocalServiceUtil.getAttendanceByQuarter(searchedUser, 
								Integer.valueOf(attendanceQuarter), searchContainerStart, searchContainerEnd);
						break;
					case 3:
						results = EmployeeAttendanceLocalServiceUtil.getAttendanceByMonth(searchedUser, 
							Integer.valueOf(attendanceMonth), searchContainerStart, searchContainerEnd);
						break;
					case 4:
						results = EmployeeAttendanceLocalServiceUtil.getAttendanceByYear(searchedUser, 
							searchContainerStart, searchContainerEnd);
						break;
					}
				}
				else
				{					
					results = EmployeeAttendanceLocalServiceUtil.getAttendanceByMonth(searchedUser, 
						Calendar.getInstance().get(Calendar.MONTH), searchContainerStart, searchContainerEnd);
				}
				total = results.size();
				searchContainer.setTotal(total);
				searchContainer.setResults(results);
				
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.hrms.model.EmployeeAttendance" 
				keyProperty="attendanceId" modelVar="currentAttendance">
	
				<% 
					Date attendanceDt = currentAttendance.getAttendanceDate();
					Date signinTime = currentAttendance.getSigninTime();
					Date signoutTime = currentAttendance.getSignoutTime();
					long timeDiff = signoutTime.getTime() - signinTime.getTime();
					double hour = (double) (timeDiff) / (1000 * 60 * 60);
					String time = (timeDiff / (1000 * 60 * 60) % 24) 
							+ " hr(s) " + ((timeDiff / (1000 * 60)) % 60) + " min(s).";
				%>
				
				<portlet:actionURL var="approveAttendanceURL">
					<portlet:param name="action" value="approveAttendance"/>
					<portlet:param name="attendanceId"
						value="<%=String.valueOf(currentAttendance.getAttendanceId())%>" />
				</portlet:actionURL>
					
				<liferay-ui:search-container-column-text name="Date">
					<%=dateFormat.format(currentAttendance.getAttendanceDate()) %>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="User" 
					value="<%=UserLocalServiceUtil.getUser(currentAttendance.getUserId()).getFullName()%>" />
				<liferay-ui:search-container-column-text 
					name="Signin Time">
					<%=timeFormat.format(currentAttendance.getSigninTime())%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="Signout Time">
					<%=timeFormat.format(currentAttendance.getSignoutTime())%>
				</liferay-ui:search-container-column-text>
				
				
				<liferay-ui:search-container-column-text name="Duration" 
					value="<%=df.format(hour)%>" />
					
				<liferay-ui:search-container-column-text name="Time" 
					value="<%=time%>" />
				
				<%-- For Attendance Approval --%>
				<liferay-ui:search-container-column-text name="Approval" cssClass="attendance-approval">
					<% if(currentAttendance.isApproved()) { %>
							<label>Approved</label>
					<% } else { %>
							<aui:a href="<%=approveAttendanceURL%>">Approve</aui:a>
					<% } %>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
		</liferay-ui:search-container>
	</div>
</aui:form>

<aui:script>
	AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters', function(A) {
		var selectedDisplayMode;
		A.one("#<portlet:namespace/>attendanceDisplayMode").on('change',function() {
			selectedDisplayMode = A.one('#<portlet:namespace/>attendanceDisplayMode').get('value');
		});
		
		
		var inputField = A.one('#attendance_searchkeywords'); // = A.one('#<portlet:namespace/>employeeName');
		
		A.one(".toggle-advanced").on('click', function() {
			if(A.one('.search-query').get('disabled')) {
				inputField = A.one('#<portlet:namespace/>employeeName');
				console.log('executed');
			}
			else
				inputField = A.one('#attendance_searchkeywords');
		});
		
		/* var searchMode = A.one('#attendance_searchkeywords');
		
		if(!searchMode.get('disabled'))
			inputField = searchMode;
		else
			inputField = A.one('#<portlet:namespace/>employeeName'); */
		
		inputField.on('keypress', function(e) {
			
			var empName = inputField.get('value');
			
			A.io.request('<%=myResourceURL%>', {
				dataType: 'json',
				method: 'POST',
				data: '&<portlet:namespace/>keywords=' + empName,
				on: {
					success: function(event, id, obj) {
						new A.AutoCompleteList({
							allowBrowserAutocomplete: 'true',
							activateFirstItem: 'true',
							autoLoad: false,
							inputNode: inputField,
							maxResults: 15,
							render: 'true',
							resultHighlighter:['phraseMatch'],
							resultFilters:['phraseMatch'],
							source: this.get('responseData'),
							on: {
								select: function(event) {
									var res = event.result.raw;
									A.one('#<portlet:namespace/>employeeId').set('value', res.userId);
								}
							},
							resultTextLocator: 'fullName'
						});
					}
				}
			});
		});
	});
</aui:script>