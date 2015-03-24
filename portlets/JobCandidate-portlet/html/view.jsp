

<%@include file="/html/init.jsp"%>

<portlet:renderURL var="formURL">
	<portlet:param name="render" value="create" />
</portlet:renderURL>

<div align="right" class="div-add-candidate">
		<aui:a href="<%=formURL %>" cssClass="div-add-candidate add-candidate-link" title="add-candidate" label="add-candidate" id="addcandidate"/>
</div>

<liferay-portlet:renderURL varImpl="candidateSearchURL" />

<aui:form method="post">
<liferay-portlet:renderURLParams varImpl="candidateSearchURL" />
		<liferay-portlet:renderURL varImpl="iteratorURL">
				<portlet:param name="title" value="<%=title %>" />
				<portlet:param name="firstName" value="<%=firstName %>" />
				<portlet:param name="personalEmail" value="<%=personalEmail %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="5" iteratorURL="<%=iteratorURL%>" deltaConfigurable="true" displayTerms="<%=new DisplayTerms(renderRequest)%>" emptyResultsMessage="No Requisition Found" 
	>
	<liferay-ui:search-form page="/html/candidateSearch.jsp" servletContext="<%=application %>">
	
	</liferay-ui:search-form>
	<liferay-ui:search-container-results>
 		<%
 		DisplayTerms displayTerms =searchContainer.getDisplayTerms();
					List<Candidate> candidateList = CandidateLocalServiceUtil.getCandidates(-1, -1);
					results = candidateList;
					total = candidateList.size();
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
				%>

	</liferay-ui:search-container-results>
	 <liferay-ui:search-container-row
       className="com.hrms.model.Candidate" 
         keyProperty="candidateId" modelVar="currentCandidate" indexVar="loop"> 
        
        		<portlet:actionURL var="deleteURL">
					<portlet:param name="action" value="deleteCandidate" />
					<portlet:param name="candidateId"
						value="<%= String.valueOf(currentCandidate.getCandidateId()) %>" />
				</portlet:actionURL>
				<portlet:renderURL  var="editdURL" >
						<portlet:param name="render" value="editCandidateDisplay"/>
						<portlet:param name="candidateId"
										value="<%= String.valueOf(currentCandidate.getCandidateId()) %>" />
				</portlet:renderURL>
				<portlet:renderURL  var="viewURL">
						<portlet:param name="render" value="viewCandidate" />
						<portlet:param name="candidateId"
										value="<%= String.valueOf(currentCandidate.getCandidateId()) %>" />
				</portlet:renderURL>
        		
        		<liferay-ui:search-container-column-text name="Sr no."  value="${loop+1}" />   
        		             	<liferay-ui:search-container-column-text name="title" property="title" />      
              	<liferay-ui:search-container-column-text name="firstName" property="firstName" /> 
         	 	<liferay-ui:search-container-column-text name="personalEmail" property="personalEmail" /> 
         	 	<liferay-ui:search-container-column-text
		name="status"
		cssClass="candidate-status"
		>
		<% if(currentCandidate.isStatus()) { %>
			<img class="state-image"  src="<%=request.getContextPath()%>/images/icon-check-green.png" alt="Active" onmouseover="Liferay.Portal.ToolTip.show(this, 'Active');"/>
		<% } else { %>
			<img class="state-image" src="<%=request.getContextPath()%>/images/icon-cross-red.png" 	alt="Inactive" onmouseover="Liferay.Portal.ToolTip.show(this, 'Inactive');"/>
		<% } %>
	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text
		name="shortListed"
		cssClass="candidate-status"
		>
		<% if(currentCandidate.isShortListed()) { %>
			<img class="state-image"  src="<%=request.getContextPath()%>/images/icon-check-green.png" alt="Active" onmouseover="Liferay.Portal.ToolTip.show(this, 'Active');"/>
		<% } else { %>
			<img class="state-image" src="<%=request.getContextPath()%>/images/icon-cross-red.png" 	alt="Inactive" onmouseover="Liferay.Portal.ToolTip.show(this, 'Inactive');"/>
		<% } %>
	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text cssClass="candidate-edit-link candidate-status" href="<%=editdURL %>">
			<img src="<%=request.getContextPath()%>/images/icon-edit.png" class="imgstate-image edit-icon" alt="Edit"/>
					</liferay-ui:search-container-column-text>
		
		
			<liferay-ui:search-container-column-text href="<%=deleteURL %>" cssClass="candidate-edit-link candidate-status">
			<img src="<%=request.getContextPath()%>/images/icon-delete.png" class="imgstate-image delete-icon candidate-edit-link img" />
					</liferay-ui:search-container-column-text>
					
			<liferay-ui:search-container-column-text cssClass="candidate-edit-link candidate-status" href="<%=viewURL %>">
			<img src="<%=request.getContextPath()%>/images/view.jpeg" class="imgstate-image view-icon candidate-edit-link img"/>
					</liferay-ui:search-container-column-text>
	
        	 	
         </liferay-ui:search-container-row> 
         <liferay-ui:search-iterator searchContainer="<%=searchContainer%>" /> 
 </liferay-ui:search-container> 
 </aui:form>
 
