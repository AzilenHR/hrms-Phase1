
<%@page import="java.util.Date"%>
<%@page import="com.hrms.model.EmployeeTimesheet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="init.jsp"%>

<portlet:actionURL var="createTimesheetURL">
	<portlet:param name="action" value="createTimesheet" />
</portlet:actionURL>

<portlet:renderURL var="listTimesheets"/>

<portlet:actionURL var="updateTimesheetURL">
	<portlet:param name="action" value="updateTimesheet"/>
	<% if((request.getAttribute("empTimesheet")) != null) {%>
		<portlet:param name="timesheetId" value="${empTimesheet.timesheetId}"/>
	<% } %>
</portlet:actionURL>


<script src="<%=request.getContextPath()%>/js/jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.timepicker.css" />

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css" />

<script src="<%=request.getContextPath()%>/js/custom.js"></script>

<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy"), 
	timeFormat = new SimpleDateFormat("hh:mm a");

	String taskDate = dateFormat.format(new Date()), taskStarttime = "", taskEndtime = "";
%>
<%	
	EmployeeTimesheet empTimesheet = (EmployeeTimesheet)request.getAttribute("empTimesheet");
	if(empTimesheet != null)
	{
		taskDate = dateFormat.format(empTimesheet.getTaskDate());
		taskStarttime = timeFormat.format(empTimesheet.getTaskStarttime());
		taskEndtime = timeFormat.format(empTimesheet.getTaskEndtime());
	}
%>



<aui:form method="post" action="${empTimesheet == null ? createTimesheetURL : updateTimesheetURL}" name="timesheetForm">
	<table>
		<tr>
			<td><aui:input name="taskTitle" cssClass="task-title" type="text" 
				value="${empTimesheet == null ? '' : empTimesheet.taskTitle}"	
				label="Task Title" required="true" /></td>
				
			<td><aui:input type="text" name='taskDate' cssClass="task-date" label="Task Date" 
				value="<%=taskDate%>" /></td>
			<td>
				<div class="div-billable-checkbox">
					<input type="checkbox" checked="${empTimesheet == null ? true : empTimesheet.billable}" 
						name='<portlet:namespace/>billable' class="task-billable-checkbox" />
					<label>Billable?</label>
				</div>
			</td>
		</tr>
		<tr>
			<td><aui:input type="text" name='starttime' cssClass="task-time starttime" label="Start Time"
				value="<%=taskStarttime%>" /></td>
			<td><aui:input type="text" name='endtime' cssClass="task-time endtime" label="End Time"
				value="<%=taskEndtime%>" /></td>
			<td><aui:input type="text" name="duration" cssClass="task-duration" label="Duration"
				value="${empTimesheet == null ? '' : empTimesheet.duration}"/></td>
		</tr>
		<tr>
			<td><aui:input name="taskDescription" type="textarea" label="Task Description"
				value="${empTimesheet == null ? '' : empTimesheet.taskDescription}" /></td>
			
			<td>
				<div class="div-task-completed">
					<input type="checkbox" class="task-completed-checkbox" name='<portlet:namespace/>taskCompleted' 
						${empTimesheet != null && empTimesheet.taskCompleted ? 'checked=\"checked\"' : ''} /> 
					<label class="task-completed-label">Completed</label>
				</div>
			</td>
		</tr>
		<tr>
			<td></td><td></td>
			<td><aui:button type="submit" value="Submit" name="submitTimesheet" /> &nbsp;&nbsp;
			<aui:button type="cancel" value="Cancel" name="cancelTimesheet" href="<%=listTimesheets%>" /></td>
		</tr>
	</table>
</aui:form>