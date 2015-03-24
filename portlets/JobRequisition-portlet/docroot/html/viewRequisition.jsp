
<%@ include file="/html/init.jsp"%>

<%
String Redirect=ParamUtil.getString(request, "backURL");
long joblibraryId = ParamUtil.getLong(request, "jobLibraryId");
JobLibrary selectJoblibraryObject=null;

if(jobLibraryId>0)
{
	
	selectJoblibraryObject=JobLibraryLocalServiceUtil.getJobLibrary((int)jobLibraryId);
	
}

%>
<%if(selectJoblibraryObject!=null){
	
%>
<table>

  <tr>
    <th class="lablecolor">Job Requisition Information<br><br></th>
 
  </tr>
   
  <tr>
    <td class="lablesize" align="left">Department </td>
    <td class="lablesize" align="left">
    
    </td>
    </tr>
    <tr>
    <td class="lablesize" align="left">Job Title </td>
    <td align="left"><%=selectJoblibraryObject.getJobTitle()%></td>
  </tr>
  <tr>
  <td class="lablesize" align="left">Number of position </td>
    <td align="left"><%=selectJoblibraryObject.getNumberOfPosition()%></td>
  </tr>
  <tr>
  	 <td class="lablesize" align="left">Job Description </td>
    <td align="left"><%=selectJoblibraryObject.getJobDescription()%></td>
     
  </tr>
  <tr>
  <td class="lablesize" align="left">Qualification </td>
    <td align="left"><%=selectJoblibraryObject.getQualifications()%></td>
    </tr>
    <tr>
    <td class="lablesize" align="left">Responsibility </td>
    <td align="left"><%=selectJoblibraryObject.getResponsibility()%></td>
  </tr>
  
</table>
<% }%>