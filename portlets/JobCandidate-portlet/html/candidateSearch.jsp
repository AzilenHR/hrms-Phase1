<%@ include file="/html/init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>