<%@ include file="/html/init.jsp"%>

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobLibarary-add-success")){%>
<liferay-ui:success key="jobLibarary-add-success" message="jobLibrary has been added successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"jobLibrary-add-error")){%>
<liferay-ui:error key="jobLibrary-add-error" message="There is an Error occured while adding jobLibrary please try again" />
<%} %>

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobLibrary-update-success")){%>
<liferay-ui:success key="jobLibrary-update-success" message="jobLibrary has been updated successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"jobLibrary-update-error")){%>
<liferay-ui:error key="jobLibrary-update-error" message="There is an Error occured while updating jobLibrary please try again" />
<%} %>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobLibrary-delete-success")){%>
<liferay-ui:success key="jobLibrary-delete-success" message="jobLibrary has been deleted successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"jobLibrary-delete-error")){%>
<liferay-ui:error key="jobLibrary-delete-error" message="There is an Error occured while deleting job library please try again" />
<%} %>
<portlet:renderURL var="formURL">
	<portlet:param name="render" value="createJobRequisition" />
</portlet:renderURL>

<div align="right" class="div-add-requisition">
		<aui:a href="<%=formURL %>" cssClass="div-add-requisition add-requisition-link" title="add-requisition" label="add-requisition" id="addrequisition"/>
	
</div>

 
 

<liferay-portlet:renderURL varImpl="joblibrarySearchURL" />
	<aui:form method="post">
		

		<liferay-portlet:renderURLParams varImpl="joblibrarySearchURL" />
		<liferay-portlet:renderURL varImpl="iteratorURL">
				<portlet:param name="jobTitle" value="<%=jobTitle %>" />
				<portlet:param name="jobDescription" value="<%=jobDescription %>" />
<%-- 				<portlet:param name="responsibility" value="<%=responsibility %>" /> --%>
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="5" iteratorURL="<%=iteratorURL%>" deltaConfigurable="true" displayTerms="<%=new DisplayTerms(renderRequest)%>" emptyResultsMessage="No Requisition Found" 
	total="<%=JobLibraryLocalServiceUtil.getJobLibrariesCount()%>" >
	<liferay-ui:search-form page="/html/joblibrarySearch.jsp" servletContext="<%=application %>">
	
	</liferay-ui:search-form>
	<liferay-ui:search-container-results>
	
 
                     <%
	DisplayTerms displayTerms =searchContainer.getDisplayTerms();
	if (displayTerms.isAdvancedSearch()) {
	total = JobLibraryLocalServiceUtil.getSearchJobLibraryCount(jobTitle,displayTerms.isAndOperator());
	searchContainer.setTotal(total);
	searchContainer.setResults(JobLibraryLocalServiceUtil.getSearchJoblibrary(jobTitle,displayTerms.isAndOperator(),searchContainer.getStart(),searchContainer.getEnd()));
	}
	else {
	String searchkeywords = displayTerms.getKeywords();
	
	total = JobLibraryLocalServiceUtil.getSearchJobLibraryCount(jobTitle,displayTerms.isAndOperator());
	searchContainer.setResults(JobLibraryLocalServiceUtil.getSearchJoblibrary(searchkeywords,false,searchContainer.getStart(),searchContainer.getEnd()));
	}
	
	%> 
    </liferay-ui:search-container-results>
        <liferay-ui:search-container-row
        className="com.hrms.model.JobLibrary"
        keyProperty="jobLibraryId" modelVar="currentJobLibrary" indexVar="loop">
        
       <portlet:actionURL var="deleteURL">
					<portlet:param name="action" value="deleteJobLibrary" />
					<portlet:param name="jobLibraryId"
						value="<%= String.valueOf(currentJobLibrary.getJobLibraryId()) %>" />
				</portlet:actionURL>
				<portlet:renderURL  var="editdURL" >
						<portlet:param name="render" value="editJobLibraryDisplay"/>
						<portlet:param name="jobLibraryId"
										value="<%= String.valueOf(currentJobLibrary.getJobLibraryId()) %>" />
				</portlet:renderURL>
				<portlet:renderURL  var="viewURL">
						<portlet:param name="render" value="viewJobLibrary" />
						<portlet:param name="jobLibraryId"
										value="<%= String.valueOf(currentJobLibrary.getJobLibraryId()) %>" />
				</portlet:renderURL>
   
        <liferay-ui:search-container-column-text name="Sr no."  value="${loop+1}" />        
            <liferay-ui:search-container-column-text name="jobTitle" property="jobTitle" />     
             <liferay-ui:search-container-column-text name="jobDescription" property="jobDescription" />
             
        
			<liferay-ui:search-container-column-text cssClass="requisition-edit-link requisition-status" href="<%=editdURL %>">
			<img src="<%=request.getContextPath()%>/images/icon-edit.png" class="imgstate-image edit-icon" alt="Edit"/>
					</liferay-ui:search-container-column-text>
		
		
			<liferay-ui:search-container-column-text href="<%=deleteURL %>" cssClass="requisition-edit-link requisition-status">
			<img src="<%=request.getContextPath()%>/images/icon-delete.png" class="imgstate-image delete-icon requisition-edit-link img" />
					</liferay-ui:search-container-column-text>
					
			<liferay-ui:search-container-column-text cssClass="requisition-edit-link requisition-status" href="<%=viewURL %>">
			<img src="<%=request.getContextPath()%>/images/view.jpeg" class="imgstate-image view-icon requisition-edit-link img"/>
					</liferay-ui:search-container-column-text>
		   </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
    
   
</liferay-ui:search-container> 
</aui:form>


 
 
