<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>"
	buttonLabel="Find" id="timesheet_search" autoFocus="true">
	<aui:input name="taskTitle" type="text" label="Task Tile" />
	<aui:input name="taskDescription" type="text" label="Task Description" />
</liferay-ui:search-toggle>