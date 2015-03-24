<%@include file="init.jsp"%>
<portlet:renderURL var="applyURL">
	<portlet:param name="action" value="apply"/>
</portlet:renderURL>
<aui:a href="<%= applyURL.toString() %>" >
Apply For Leave
</aui:a>
