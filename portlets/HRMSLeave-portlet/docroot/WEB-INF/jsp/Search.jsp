<%@include file="init.jsp" %>

<%
	SearchContainer searchContainer=(SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms=searchContainer.getDisplayTerms();

%>

<liferay-ui:search-toggle
	buttonLabel="Search"
	displayTerms="<%=displayTerms %>"
	id="toggle_id_search">
	<aui:input label="leave Name" name="leaveName" value="<%=leaveName %>"></aui:input>
	<aui:input name="LeavesAllowedPerYear" label="Leaves Allowed Per Year" value="<%=leavesAllowedPerYear %>"/>
	
</liferay-ui:search-toggle>