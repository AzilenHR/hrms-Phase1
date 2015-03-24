<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.service.EmployeeTimesheetLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@include file="init.jsp"%>

<liferay-portlet:renderURL varImpl="timesheetSearchURL">
</liferay-portlet:renderURL>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css" />

<portlet:renderURL var="addTimesheetURL"> <%-- windowState="<%=LiferayWindowState.POP_UP.toString()%>"> --%>
		<portlet:param name="render" value="addTimesheet"/>
</portlet:renderURL>

<aui:form method="post" action="<%=timesheetSearchURL %>"> 

	<liferay-portlet:renderURLParams varImpl="timesheetSearchURL" />
	
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<liferay-portlet:param name="taskDescription" value="<%=taskDescription %>"/>
		<liferay-portlet:param name="taskTitle" value="<%=taskTitle %>"/>
	</liferay-portlet:renderURL>
	
	
	
	<div class="div-add-timesheet">
		<aui:a href="<%=addTimesheetURL%>" cssClass="add-timesheet-link" label="Add Timesheet" /> <%-- <%=addTimesheetURL%> --%>
	</div>
	
	<% SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy"), 
		timeFormat = new SimpleDateFormat("hh:mm a");%>
	<div class="employee-timesheets">
	<liferay-ui:search-container delta="20" deltaConfigurable="true" iteratorURL="<%=iteratorURL%>" 
		displayTerms="<%=new DisplayTerms(renderRequest)%>" emptyResultsMessage="No Timesheets Found">
		<liferay-ui:search-form page="/html/jsp/TimesheetSearch.jsp" servletContext="<%=application %>" />
		<liferay-ui:search-container-results>
		<%
			
			DisplayTerms displayTerms = searchContainer.getDisplayTerms();
			if(displayTerms.isAdvancedSearch())
			{	
				total = EmployeeTimesheetLocalServiceUtil.getEmployeeTimesheetCount(taskTitle, taskDescription, 
						displayTerms.isAndOperator());
				results = EmployeeTimesheetLocalServiceUtil.getEmployeeTimesheets(taskTitle, taskDescription, 
						displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
				searchContainer.setTotal(total);
				searchContainer.setResults(results);
			}
			else
			{
				String keywords = displayTerms.getKeywords();
				total = EmployeeTimesheetLocalServiceUtil.getEmployeeTimesheetCount(keywords, 
						keywords, displayTerms.isAndOperator());
				results = EmployeeTimesheetLocalServiceUtil.getEmployeeTimesheets(keywords, keywords, false, 
						searchContainer.getStart(), searchContainer.getEnd());
				searchContainer.setTotal(total);
				searchContainer.setResults(results);
			}
		%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.hrms.model.EmployeeTimesheet" keyProperty="timesheetId"
			modelVar="currentTimesheet">

			<portlet:renderURL var="editTimesheetURL">
				<portlet:param name="render" value="editTimesheet" />
				<portlet:param name="timesheetId"
					value="<%=String.valueOf(currentTimesheet.getTimesheetId())%>" />
			</portlet:renderURL>

			<portlet:actionURL var="deleteTimesheetURL">
				<portlet:param name="action" value="deleteTimesheet"/>
				<portlet:param name="timesheetId"
					value="<%=String.valueOf(currentTimesheet.getTimesheetId())%>" />
			</portlet:actionURL>
			
			<portlet:actionURL var="completeTaskURL">
				<portlet:param name="action" value="completeTimesheetTask"/>
				<portlet:param name="timesheetId"
					value="<%=String.valueOf(currentTimesheet.getTimesheetId())%>" />
			</portlet:actionURL>

			<liferay-ui:search-container-column-text name="Date">
				<%=dateFormat.format(currentTimesheet.getTaskDate()) %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="User" 
				value="<%=UserLocalServiceUtil.getUser(currentTimesheet.getUserId()).getFullName()%>" />
			<liferay-ui:search-container-column-text name="Task" buffer="buffer" cssClass="task-title-link">
			<%
				buffer.append("<a href='#' style='text-decoration: none;' id='" 
				+ currentTimesheet.getTimesheetId() + "' class='task-details'>" 
				+ currentTimesheet.getTaskTitle() 
				+ "</a><input type='hidden' name='taskDescription' timesheetId='" 
						+ currentTimesheet.getTimesheetId() + "' class='task-desc' value='" 
				+ currentTimesheet.getTaskDescription() + "' />");
			%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text 
				name="Start Time">
				<%=timeFormat.format(currentTimesheet.getTaskStarttime())%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="End Time">
				<%=timeFormat.format(currentTimesheet.getTaskEndtime())%>
			</liferay-ui:search-container-column-text>
				
			<%-- For Billable --%>
			<liferay-ui:search-container-column-text name="Billable" cssClass="task-billable">
				<% if(currentTimesheet.isBillable()) { %>
					<img class="state-image" src="<%=request.getContextPath()%>/images/icon-check-green.png" 
						alt="Checked" />
				<% } else { %>
					<img class="state-image" src="<%=request.getContextPath()%>/images/icon-cross-red.png" 
						alt="Unchecked" />
				<% } %>
			</liferay-ui:search-container-column-text>
			
			
			<%-- For Billed --%>
			<liferay-ui:search-container-column-text name="Billed" cssClass="task-billed">
				<% if(currentTimesheet.isBilled()) { %>
					<img class="state-image" src="<%=request.getContextPath()%>/images/icon-check-green.png" 
						alt="Checked" />
				<% } else { %>
					<img class="state-image" src="<%=request.getContextPath()%>/images/icon-cross-red.png" 
						alt="Unchecked" />
				<% } %>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Time Duration"
				property="duration" value="<%=String.valueOf(currentTimesheet.getDuration())%>" />
			
			<%-- For Task Completion --%>
			<liferay-ui:search-container-column-text name="Completed" cssClass="task-completed">
				<% if(currentTimesheet.isTaskCompleted()) { %>
						<label>Completed</label>
				<% } else { %>
						<aui:a href="<%=completeTaskURL%>">Complete</aui:a>
				<% } %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text href="<%=editTimesheetURL%>" cssClass="timesheet-edit-link">
				<img src="<%=request.getContextPath()%>/images/icon-edit.png" class="state-image edit-icon" alt="Edit"/>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text href="<%=deleteTimesheetURL%>" cssClass="timesheet-delete-link">
				<img src="<%=request.getContextPath()%>/images/icon-delete.png" class="state-image delete-icon" alt="Delete"/>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</liferay-ui:search-container>
</div>
</aui:form>
<div id ="myBox" style="text-align: justify;" title="Tasks"></div>

<script type="text/javascript">
<!--
	$('.task-details').on('click', function(event) {
		event.preventDefault();
		var timesheetID = $(this).attr('id');
		var taskTitle = $(this).html();
		$('#myBox').prop('title', taskTitle);
		var htmlBox = ""; //"<h4>" + taskTitle + "</h4>";
		var taskDesc = $('input[timesheetId="' + timesheetID + '"]');
        htmlBox += "<p>" + taskDesc.val() + "</p>";
		
		$("#myBox").dialog({

	        autoOpen: false,
	        modal: true,
	        title: taskTitle,
	        show: {
	            effect: "fade",
	            duration: 500
	        },
	        hide: {
	            effect: "fade",
	            duration: 500
	        }
	    });
		$("#myBox").html(htmlBox);
	  	$("#myBox").dialog("open");
	});
//-->
</script>
<%-- <aui:script use="liferay-util-window">
A.one('.add-timesheet-link').on('click', function(event) {
    Liferay.provide(window, 'showDialog', function(render) {
        page = '<%=addTimesheetURL.toString()%>'
        Liferay.Util.openWindow({
            dialog: {
                cache: false,
                centered: true,
                height: 400,
                modal: true,
                resizable: false,
                width: 900
            },
            id: 'dialog',
            title: "Add/Edit Timesheet",
            uri: page
        });
    });
});
</aui:script>

<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
</aui:script>
<aui:script>
    Liferay.provide(window, 'closePopup', function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script> --%>
<%-- <aui:script>
var addTimesheetDialog;

AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A) {
  
    A.one('.add-timesheet-link').on('click', function(event) {
    	addTimesheetDialog = Liferay.Util.Window.getWindow({
	       	dialog: {
	            centered: true,
	            constrain2view: true,
	            modal: true,
	            resizable: true,
	            width: 980,
	            height: 420
           	} 
    	}).plug(A.Plugin.DialogIframe, {
	    	autoLoad: true,
	        iframeCssClass: 'dialog-iframe',
	        uri : '<%=addTimesheetURL.toString()%>'
        }).render();
   		addTimesheetDialog.show();
  		addTimesheetDialog.titleNode.html("Add"); 
  		addTimesheetDialog.io.start();
     });
 });
 </aui:script> --%>