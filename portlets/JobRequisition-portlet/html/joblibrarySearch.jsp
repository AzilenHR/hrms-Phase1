
<%@ include file="/html/init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle
	buttonLabel="Find"
	displayTerms="<%= displayTerms %>"
	id="joblibrary_search" autoFocus="true">
	
	<aui:input name="jobTitle" type="text" />
	

</liferay-ui:search-toggle>
