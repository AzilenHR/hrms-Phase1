
<%@include file="init.jsp"%>

<%if(SessionMessages.contains(renderRequest.getPortletSession(),"leave-added-successfully")){%>
	<liferay-ui:success key="leave-added-succefully" message="leave has been added successfully"/>
<% }%>

<%if(SessionMessages.contains(renderRequest.getPortletSession(),"leave-update-successfully")){%>
	<liferay-ui:success key="leave-update-successfully" message="leave has been updated successfully"/>

<%} %>
<%if(SessionMessages.contains(renderRequest.getPortletSession(), "leave-delete-successfully")){%>
	
	<liferay-ui:success key="leave-delete-successfully" message="leave has been deleted successfully"/>
	<%} %>
<%if(SessionErrors.contains(renderRequest.getPortletSession(),"leave-update-error")){%>
	
	<liferay-ui:error key="leave-update-error" message="leave can't be updated because u have entered wrong value"/>
	<%}%>

<%
	long ID=ParamUtil.getLong(request, "leaveId");
%>


<portlet:renderURL var="add" >
	<portlet:param name="action" value="add" />
</portlet:renderURL>



<%-- <aui:form action="${add}" method="post"  style="float: right;"> --%>
<%-- 	<aui:button name="AddLeaveType"  value="Add Leave Type" id="addLeave" type="submit" /> --%>
<%-- </aui:form> --%>

<div class="add-leave-link">
	<aui:a href="${add}" cssClass="add-leave-linka"  id="addLeave" label="Add Leave Type" />
</div>




 <portlet:renderURL var="edit" > 
 	<portlet:param name="action" value="editleaveURL"/> 
 </portlet:renderURL>
 
<liferay-portlet:renderURL varImpl="leaveSearchURL">
	<portlet:param name="mvcPath" value="/jsp/display.jsp"/>
</liferay-portlet:renderURL>

<aui:form action="<%=leaveSearchURL %>" method="get" name="leavefm" >
	<liferay-portlet:renderURLParams varImpl="leaveSearchURL"/>
	<liferay-portlet:renderURL varImpl="iteratorURL">
	
		<portlet:param name="leaveName" value="<%=leaveName%>" />
		<portlet:param name="leaveType" value="<%=leaveType %>"/>
		<portlet:param name="leavesAllowedPerYear" value="<%=String.valueOf(leavesAllowedPerYear)%>"/>
		<portlet:param name="carryOver" value="<%=String.valueOf(carryOver)%>"/>
		<portlet:param name="encachement" value="<%=String.valueOf( encachement)%>"/>
		<portlet:param name="Status" value="<%=String.valueOf(Status)%>"/>		
		<portlet:param name="jspPage" value="/jsp/display.jsp"/>

	</liferay-portlet:renderURL>
	
	
<liferay-ui:search-container
	displayTerms="<%=new DisplayTerms(renderRequest)%>"
	emptyResultsMessage="no -leaves"
	iteratorURL="<%=iteratorURL %>"
	delta="5"
	deltaConfigurable="true"
	
>

<liferay-ui:search-form page="/WEB-INF/jsp/Search.jsp"
 						servletContext="<%=application %>" ></liferay-ui:search-form> 
<liferay-ui:search-container-results>
<%
	total=LeaveLocalServiceUtil.getLeavesCount();
	searchContainer.setTotal(total);
	results=LeaveLocalServiceUtil.getLeaves(searchContainer.getStart(), searchContainer.getEnd());
	searchContainer.setResults(results);	
	
	DisplayTerms displayTerms=searchContainer.getDisplayTerms();
	
 	 if(displayTerms.isAdvancedSearch())
 		{	 
 		total=LeaveLocalServiceUtil.getSearchLeavesCount(leaveName, leaveType, leavesAllowedPerYear, carryOver, encachement, Status, displayTerms.isAndOperator(),searchContainer.getStart(),searchContainer.getEnd());
		results=LeaveLocalServiceUtil.getSearchLeaves(leaveName, leaveType, leavesAllowedPerYear, carryOver, encachement, Status, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
 		searchContainer.setTotal(total);
		searchContainer.setResults(LeaveLocalServiceUtil.getSearchLeaves(leaveName, leaveType, leavesAllowedPerYear, carryOver, encachement, Status, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd()));
		
		} 
	 
 	 else
 		 {
	 		
		 		String searchkeywords=displayTerms.getKeywords();
		 		//String numbersearchkeywords=Validator.isNumber(searchkeywords)?searchkeywords;
				String numbersearchkeywords=Validator.isNumber(searchkeywords)?searchkeywords:String.valueOf(0);
				//String boolsearchkeywords=Validator.isNotNull(searchkeywords)?searchkeywords:String.valueOf(0);
				total=LeaveLocalServiceUtil.getSearchLeavesCount(searchkeywords, searchkeywords, Integer.parseInt(numbersearchkeywords), Boolean.parseBoolean(numbersearchkeywords), Boolean.parseBoolean(numbersearchkeywords),Boolean.parseBoolean(numbersearchkeywords),displayTerms.isAndOperator(),searchContainer.getStart(),searchContainer.getEnd());
				//total=SoftEngineerLocalServiceUtil.getSearchEngineersCount(searchkeywords, searchkeywords, searchkeywords, Long.parseLong(numbersearchkeywords), displayTerms.isAndOperator());
				//searchContainer.setResults(SoftEngineerLocalServiceUtil.getSearchEngineers(searchkeywords, searchkeywords, searchkeywords, Long.parseLong(numbersearchkeywords), false, searchContainer.getStart(),searchContainer.getEnd()));
				searchContainer.setResults(LeaveLocalServiceUtil.getSearchLeaves(searchkeywords, searchkeywords,  Integer.parseInt(numbersearchkeywords), Boolean.parseBoolean(numbersearchkeywords), Boolean.parseBoolean(numbersearchkeywords),Boolean.parseBoolean(numbersearchkeywords),false,searchContainer.getStart(), searchContainer.getEnd()));
 		 }
	

// //   	 
%>

</liferay-ui:search-container-results>
<liferay-ui:search-container-row
 className="Leave"
 keyProperty="leaveId"
 modelVar="currentLeave">



<%-- <% System.out.println("value for currentUser is"+value);%>  --%>
<%--  <liferay-portlet:renderURL varImpl="rowURL"> --%>
 
<%--  	<portlet:param name="backURL" value="<%=currentURL %>"/> --%>
<%--  	<portlet:param name="mvcPath" value="/jsp/display.jsp"/> --%>
<%--  	<portlet:param name="redirect" value="<%=currentURL %>"/> --%>
<%--  	<portlet:param name="leaveId" value="<%=String.valueOf(currentLeave.getLeaveId()) %>"/> --%>
 	
<%-- </liferay-portlet:renderURL> --%>

<liferay-portlet:renderURL var="rowURL">
<portlet:param name="action" value="editleaveURL"/>
<portlet:param name="redirect" value="<%= currentURL %>" />
<portlet:param name="ID" value="<%=String.valueOf(currentLeave.getLeaveId()) %>"/>
</liferay-portlet:renderURL>


<liferay-ui:search-container-column-text
	
	name="Title"
	value="<%=currentLeave.getLeaveName()  %>"
	/>

 <liferay-ui:search-container-column-text
	
	name="LeaveType"
	value="<%=currentLeave.getLeaveType()%>"
	/>
  	<liferay-ui:search-container-column-text
    	 
    	name="LeavesAllowedPerYear"   
   	value="<%=String.valueOf(currentLeave.getLeavesAllowedPerYear()) %>" />   
   	
   	 <liferay-ui:search-container-column-text
    	   
    	name="CarryOver"   
   	value="<%=String.valueOf(currentLeave.getCarryOver())%>" />  
   	<liferay-ui:search-container-column-text
   	name="carryOverLimit"
   	value="<%=String.valueOf(currentLeave.getCarryOverLimit() )%>">
   	
   	</liferay-ui:search-container-column-text>
   	
   	 <liferay-ui:search-container-column-text
    	  
    	name="Encachement"   
   	value="<%=String.valueOf(currentLeave.getEncachement()) %>" />  
  	
  	<liferay-ui:search-container-column-text
    	   name="Status"
    	   cssClass="leave-status"
    	   >    
   	<% if(currentLeave.isStatus()) { %>
			<img class="state-image"  src="<%=request.getContextPath()%>/image/icon-check-green.png" alt="Active" onmouseover="Liferay.Portal.ToolTip.show(this, 'Active');"/>
		<% } else { %>
			<img class="state-image" src="<%=request.getContextPath()%>/image/icon-cross-red.png" 	alt="Inactive" onmouseover="Liferay.Portal.ToolTip.show(this, 'Inactive');"/>
		<% }%>
		</liferay-ui:search-container-column-text>
    	<liferay-ui:search-container-column-text 
    		 
    		href="${rowURL }"
    		cssClass="leave-edit-link leave-status" >
    			
    				<img class="state-image edit-icon" src="<%=request.getContextPath()%>/image/edit.png" alt="Edit" onclick="editleaveURL(${currentLeave.getLeaveId()});"/>
    			 
    		</liferay-ui:search-container-column-text> 	
 </liferay-ui:search-container-row>
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>"></liferay-ui:search-iterator>
</liferay-ui:search-container>
</aui:form>