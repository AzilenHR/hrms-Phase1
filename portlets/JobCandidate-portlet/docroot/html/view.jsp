
<%@page import="com.hrms.service.CandidateLocalServiceUtil"%>
<%@include file="/html/init.jsp"%>

<portlet:renderURL var="formURL">
	<portlet:param name="render" value="create" />
</portlet:renderURL>

<div align="right" class="div-add-candidate">
		<aui:a href="<%=formURL %>" cssClass="div-add-candidate add-candidate-link" title="add-candidate" label="add-candidate" id="addcandidate"/>
</div>
<%-- <liferay-portlet:renderURL varImpl="candidateSearchURL" /> --%>
<%-- 	<aui:form method="post"> --%>
	
<%-- <liferay-portlet:renderURLParams varImpl="candidateSearchURL" /> --%>
<%-- 		<liferay-portlet:renderURL varImpl="iteratorURL"> --%>
		
<%-- 				<portlet:param name="title" value="<%=title %>" /> --%>
<%-- 				<portlet:param name="firstName" value="<%=firstName %>" /> --%>
<%-- 				<portlet:param name="middleName" value="<%=middleName %>" /> --%>
<%-- </liferay-portlet:renderURL> --%>

<%-- <liferay-ui:search-container delta="5" iteratorURL="<%=iteratorURL%>" deltaConfigurable="true" emptyResultsMessage="No Candidate Found"  --%>
<%-- 	 > --%>
<%-- 	<liferay-ui:search-container-results> --%>
<%-- <%-- 			<% --%> 
<!-- // 				DisplayTerms displayTerms =searchContainer.getDisplayTerms(); -->
<%-- <%-- 			%>	 --%> 
<%-- 	</liferay-ui:search-container-results> --%>
<%-- 	 <liferay-ui:search-container-row --%>
<%--         className="com.hrms.model.Candidate" --%>
<%--         keyProperty="candidateId" modelVar="currentCandidate" indexVar="loop"> --%>
        
<%--         		<liferay-ui:search-container-column-text name="Sr no."  value="${loop+1}" />         --%>
<%--             	<liferay-ui:search-container-column-text name="title" property="title" />      --%>
<%--              	<liferay-ui:search-container-column-text name="firstName" property="firstName" /> --%>
<%--         	 	<liferay-ui:search-container-column-text name="middleName" property="middleName" /> --%>
        	 	
<%--         </liferay-ui:search-container-row> --%>
<%--         <liferay-ui:search-iterator searchContainer="<%=searchContainer%>" /> --%>
<%-- </liferay-ui:search-container> --%>
<%-- </aui:form> --%>
