
<%@include file="/html/init.jsp"%>

<%
	JobLibrary joblibrary = (JobLibrary) request
			.getAttribute("joblibrary");
%>
<%
	System.out.println(joblibrary);
System.out.println(joblibrary);
%>
<portlet:actionURL var="addRequisitionURL">
	<portlet:param name="action" value="addRequisition" />
</portlet:actionURL>
<%-- <portlet:actionURL var="editRequisitionURL"> --%>
<%-- 	<portlet:param name="action" value="updateRequisition" /> --%>
<%-- 	<c:if test="${joblibrary != null}"> --%>
<%-- 		<portlet:param name="jobLibraryId" value="${joblibrary.jobLibraryId }"/> --%>
<%-- 	</c:if> --%>
<%-- </portlet:actionURL> --%>
<table>
<tbody>
<aui:form method="post" action="<%= addRequisitionURL%>"
	commandName="reg">
	<aui:input name="jobLibraryId" type="hidden" value='${joblibrary==null?"":joblibrary.jobLibraryId }' />
	 <tr>
    <th class="WebHR_Heading2">ADD JOB REQUISITION FORM</th>
    
  </tr>
  <tr align="left">
    <td width="70%"><aui:select name="employeedepartmentList" label="Department-list"
		>
	<<c:forEach
			items="<%=EmployeeDepartmentLocalServiceUtil
								.getEmployeeDepartments(-1, -1)%>"
			var="employeeDepartment">
			<aui:option value="${employeeDepartment.employeeDepartmentId}"
				selected="${jobLibrary.employeeDepartmentId == employeeDepartment.employeeDepartmentId? 'true' : 'false'}">${employeeDepartment.employeeDepartmentName}</aui:option>
		</c:forEach>
	</aui:select></td>
	 <td><aui:select name="employeeList" label="Report-To:" >
	<<c:forEach
			items="<%=EmployeeMstLocalServiceUtil.getEmployeeMsts(
								-1, -1)%>"
			var="employee">
			<aui:option value="${employeemst.employeeId}"
				selected="${joblibrary.reportsToId == employeemst.employeeId? 'true' : 'false'}">${employeemst.employeeName}</aui:option>
		</c:forEach>
	</aui:select></td>
	</tr>
	<tr>
	<td>
   
    <aui:input  name="jobTitle" type="text"
		required="true" value='${joblibrary==null?"":joblibrary.jobTitle }'
		 label="Job Title " cssClass="WebHRForm1"></aui:input></td>
		 <td>
		<aui:input name="numberOfPosition" type="text" class="WebHRForm1"
		required="true"
		value='${joblibrary==null?"":joblibrary.numberOfPosition }'
		placeholder="numberOfPosition" label="NumberOfPosition " ></aui:input>
		</td>
  </tr>
 
  <tr align="left">
 	<td><aui:input  name="salaryStartRange" type="text"
		required="true"
		value='${joblibrary==null?"":joblibrary.salaryStartRange }'
		placeholder="salaryStartRange" label="SalaryStartRange " cssClass="WebHRForm1"></aui:input></td>
		
		<td ><aui:input  name="salaryEndRange" type="text"
		required="true"
		value='${joblibrary==null?"":joblibrary.salaryEndRange }'
		placeholder="salaryEndRange" label="SalaryEndRange " cssClass="WebHRForm1"></aui:input></td>
  </tr>
  <tr>
  
  <td colspan="2"><label>Job Description::<br></label>
  
  <liferay-ui:input-localized name="jobDescription" xml="" type="editor" required="true" 
		value='${joblibrary==null?"":joblibrary.jobDescription }'
		placeholder="jobDescription"/><br>
  </td>
  
 </tr>
 <tr>
  <td colspan="2"><label>Responsibility::<br> </label><liferay-ui:input-localized name="responsibility" xml="" type="editor" required="true"
		value='${joblibrary==null?"":joblibrary.responsibility }'
		placeholder="responsibility" /><br>
  
  </td>
  </tr>
  <tr>
  
  <td colspan="2"><label>Qualifications::<br></label><liferay-ui:input-localized name="qualifications" xml="" type="editor" required="true"
		value='${joblibrary==null?"":joblibrary.qualifications }'
		placeholder="qualifications"/><br>
    </td>
  
  </tr>
  <tr>
  <td colspan="2"><label>Experience::<br></label><liferay-ui:input-localized name="experience" xml="" type="editor" 
		placeholder="experience" /><br>
  
  </td>
  
  </tr>
  <tr>
  
  <td colspan="2"> <label>Benefits::<br></label><liferay-ui:input-localized name="benefits" xml="" type="editor" required="true" value='${joblibrary==null?"":joblibrary.benefits }'
		placeholder="benefits" />
  
  </td>
  
  </tr>
  <tr>
  <td colspan="2" align="center"><aui:button type="submit" name="submit" value="Save" /></td>
  </tr>
	</aui:form>
</tbody>
 
</table>
