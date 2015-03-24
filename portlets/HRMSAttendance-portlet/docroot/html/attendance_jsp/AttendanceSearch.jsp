
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="init.jsp"%>

<style type="text/css">
div.div-attendance-date, div.div-attendance-quarter, div.div-attendance-month
	{
	display: none;
}

div.advance-search>.search-query, div.advance-search>button {
	border-radius: 0 !important;
}

.search-query {
	display: none;
}
</style>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<aui:input name="employeeId" type="hidden" cssClass="employee-id" />

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>"
	buttonLabel="Find" id="attendance_search" autoFocus="true">
	<br />
	<input name='<portlet:namespace/>employeeName' type="text"
		id='<portlet:namespace/>employeeName' placeholder="Employee Name"
		class="employee-name-search" />
	<aui:select name="attendanceDisplayMode"
		cssClass="attendance-displayMode" showEmptyOption="true"
		label="Display for:">
		<aui:option value="1">Day</aui:option>
		<aui:option value="2">Quarter</aui:option>
		<aui:option value="3">Month</aui:option>
		<aui:option value="4">Current Year</aui:option>
	</aui:select>
	<div class="div-attendance-date">
		<aui:input name="attendanceDate" cssClass="attendance-date-text"
			type="text" label="Attendance Date" disabled="disabled" />
	</div>
	<div class="div-attendance-quarter">
		<aui:select name="attendanceQuarter" label="Select Quarter: ">
			<c:forEach begin="1" end="4" step="1" var="quarterIndex">
				<aui:option value="${quarterIndex}">${quarterIndex}</aui:option>
			</c:forEach>
		</aui:select>
	</div>
	<div class="div-attendance-month">
		<aui:select name="attendanceMonth" label="Select Month: ">
			<c:forEach begin="1" end="12" step="1" var="monthIndex">
				<aui:option value="${monthIndex - 1}">${monthIndex}</aui:option>
			</c:forEach>
		</aui:select>
	</div>
</liferay-ui:search-toggle>