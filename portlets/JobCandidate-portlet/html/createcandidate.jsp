<%@page import="com.hrms.service.EmployeeSubDepartmentLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@include file="/html/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactory"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<head>
<script src="<%=request.getContextPath()%>/js/jquery-1.6.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.8.15.custom.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jqueryCalendar.css">

<style type="text/css">

	.HR_Form1 {
    font-family: "Titillium Web",sans-serif;
    font-size: 12px;
    font-weight: normal;
    color: rgb(88, 100, 126);
    border-width: 0px 0px 1px;
    border-style: none none solid;
    border-color: -moz-use-text-color -moz-use-text-color rgb(185, 185, 185);
    background-color: transparent;
    border-top: 0px; 
 	border-right: 0px; 
 	border-left: 0px; 
 	border-bottom: 1px solid; 
	}
	.HR_Heading2 {
    font-size: 18px;
    font-weight: normal;
    font-family: "Titillium Web",sans-serif;
    color: rgb(100, 55, 115);
	}
	
	.control-label{
	display: inline-block;
    font-weight: bold;
    margin-bottom: 0px;
      width:180px;
}
  #textBox .field{ 
   padding-left:10px;
 	border-top: 0px; 
 	border-right: 0px; 
 	border-left: 0px; 
 	border-bottom: 1px solid; 
 	width: 180px;
 } 
 #textBox .lable{
 width: 180px;
 }
 #drop .aui-field-select {
border-top: 0px;
border-right: 0px;
border-left: 0px;
border-bottom: 1px solid;
width: 180px;
height: 50px;
}
.FieldValue {
    color: #000000;
    float: left;
    font-family: "Titillium Web",sans-serif;
    font-size: 12px;
    margin-top: 12px;
}
.fieldset {
    border: 0 none;
    margin: 0;
    padding: 0;
}
label {
    display: inline-block;
    font-weight: bold;
    margin-bottom: 5px;
}
</style >
</head>
<%
	Candidate candidate=(Candidate) request.getAttribute("candidate");
%>

<portlet:actionURL var="addCandidateURL">
	<portlet:param name="action" value="addCandidate" />
</portlet:actionURL>
<table>
<tbody>
<aui:form method="post"  name="candidateModel" id="candidateModel" action="<%=addCandidateURL%>" modelAttribute="candidateModel"
	>
	<aui:input name="candidateId" type="hidden" value='${candidate==null?"":candidate.candidateId }' />
<tr>

<td width="700px">
<div align="left"  class="HR_Heading2">Candidate Information<br><br></div>
			<aui:select inlineLabel="true" name="employeedepartmentList" label="Department-list      ">
				<<c:forEach
			items="<%=EmployeeDepartmentLocalServiceUtil
								.getEmployeeDepartments(-1, -1)%>"
			var="employeeDepartment">
			<aui:option value="${employeeDepartment.employeeDepartmentId}"
				selected="${candidate.employeeDepartmentId == employeeDepartment.employeeDepartmentId? 'true' : 'false'}">${employeeDepartment.employeeDepartmentName}</aui:option>
		</c:forEach>
		</aui:select>
		<aui:select inlineLabel="true" name="employeeSubDepartmentList" label="SubDepartment-list      ">
				
			<aui:option value="0">0</aui:option>
		</aui:select>
		
		<aui:select name="employeedesignationList" inlineLabel="true" label="Designation-list">
	<c:forEach
			items="<%=EmployeeDesignationLocalServiceUtil
								.getEmployeeDesignations(-1, -1)%>"
			var="employeeDesignation">
			<aui:option value="${employeeDesignation.employeeDesignationId}"
				selected="${candidate.employeeDesignationId == employeeDesignation.employeeDesignationId? 'true' : 'false'}">${employeeDesignation.employeeDesignationName}</aui:option>
		</c:forEach>
	</aui:select>
	
	
	<aui:input  name="title" type="text" cssClass="field"
		value='${candidate==null?"":candidate.title }'
		 label="Title" inlineLabel="true"></aui:input>
	
	
		
	<aui:input  name="firstName" type="text"
		required="true" value='${candidate==null?"":candidate.firstName }'
		 label="First Name " inlineLabel="true"></aui:input>
		
	
	
	<aui:input  name="middleName" type="text" inlineLabel="true"
		required="true" value='${candidate==null?"":candidate.middleName }'
		 label="Middle Name "></aui:input>
		
			
		<aui:input  name="lastName" type="text" inlineLabel="true"
			required="true" value='${candidate==null?"":candidate.lastName }'
			 label="Last Name "></aui:input>
		
	<aui:select id="selGender" class="WebHRForm1"  name="gender" label="Gender" inlineLabel="true">
	<option value="0" selected="true">Male</option>
	<option value="1">Female</option>
	<option value="2"></option>
	</aui:select>

	<aui:select id="selNationality" class="WebHRForm1" name="nationality" label="Nationality" inlineLabel="true">
		<option value="" selected="true"></option>
	<option value="Afghan">Afghan</option>
	<option value="Albanian">Albanian</option>
	<option value="Algerian">Algerian</option>
	<option value="American">American</option>
	<option value="Andorran">Andorran</option>
	<option value="Angolan">Angolan</option>
	<option value="Argentine">Argentine</option>
	<option value="Armenian">Armenian</option>
	<option value="Australian">Australian</option>
	<option value="Austrian">Austrian</option>
	<option value="Azerbaijani">Azerbaijani</option>
	<option value="Bahamian">Bahamian</option>
	<option value="Bahraini">Bahraini</option>
	<option value="Bangladesh">Bangladesh</option>
	<option value="Barbadian">Barbadian</option>
	<option value="Belarusian">Belarusian</option>
	<option value="Belgian">Belgian</option>
	<option value="Belizean">Belizean</option>
	<option value="Beninese">Beninese</option>
	<option value="Bermudian">Bermudian</option>
	<option value="Bhutanese">Bhutanese</option>
	<option value="Bosnian">Bosnian</option>
	<option value="Botswanan">Botswanan</option>
	<option value="Brazilian">Brazilian</option>
	<option value="Bruneian">Bruneian</option>
	<option value="Bulgarian">Bulgarian</option>
	<option value="Burkinabe">Burkinabe</option>
	<option value="Burmese">Burmese</option>
	<option value="Burundian">Burundian</option>
	<option value="Cambodian">Cambodian</option>
	<option value="Cameroonian">Cameroonian</option>
	<option value="Canadia">Canadia</option>
	<option value="Cape Verdian">Cape Verdian</option>
	<option value="Caymanian">Caymanian</option>
	<option value="Central African">Central African</option>
	<option value="Chadian">Chadian</option>
	<option value="Chilean">Chilean</option>
	<option value="Chinese">Chinese</option>
	<option value="Christmas Islander">Christmas Islander</option>
	<option value="Colombian">Colombian</option>
	<option value="Comoran">Comoran</option>
	<option value="Congolese">Congolese</option>
	<option value="Congolese">Congolese</option>
	<option value="Costa Rican">Costa Rican</option>
	<option value="Croat">Croat</option>
	<option value="Cuban">Cuban</option>
	<option value="Cypriot">Cypriot</option>
	<option value="Czech">Czech</option>
	<option value="Danish">Danish</option>
	<option value="Djibouti">Djibouti</option>
	<option value="Dominican">Dominican</option>
	<option value="Dutch">Dutch</option>
	<option value="Dutch Antillean">Dutch Antillean</option>
	<option value="East Timorese">East Timorese</option>
	<option value="Ecuadorian">Ecuadorian</option>
	<option value="Egyptian">Egyptian</option>
	<option value="Emirati">Emirati</option>
	<option value="English">English</option>
	<option value="Equatorial Guinean">Equatorial Guinean</option>
	<option value="Eritrean">Eritrean</option>
	<option value="Estonian">Estonian</option>
	<option value="Ethiopian">Ethiopian</option>
	<option value="Falkland Islander">Falkland Islander</option>
	<option value="Faroese">Faroese</option>
	<option value="Fijian">Fijian</option>
	<option value="Filipino">Filipino</option>
	<option value="Finnish">Finnish</option>
	<option value="French">French</option>
	<option value="French Polynesian">French Polynesian</option>
	<option value="Gabonese">Gabonese</option>
	<option value="Gambian">Gambian</option>
	<option value="Georgian">Georgian</option>
	<option value="German">German</option>
	<option value="Ghanaian">Ghanaian</option>
	<option value="Greek">Greek</option>
	<option value="Greenlander">Greenlander</option>
	<option value="Grenadian">Grenadian</option>
	<option value="Guatemalan">Guatemalan</option>
	<option value="Guinea-Bissauan">Guinea-Bissauan</option>
	<option value="Guinean">Guinean</option>
	<option value="Guyanese">Guyanese</option>
	<option value="Haitian">Haitian</option>
	<option value="Honduran">Honduran</option>
	<option value="Hungarian">Hungarian</option>
	<option value="I-Kiribati">I-Kiribati</option>
	<option value="Icelandic">Icelandic</option>
	<option value="Indian">Indian</option>
	<option value="Indonesian">Indonesian</option>
	<option value="Iranian">Iranian</option>
	<option value="Iraqi">Iraqi</option>
	<option value="Irish">Irish</option>
	<option value="Israeli">Israeli</option>
	<option value="Italian">Italian</option>
	<option value="Ivorian">Ivorian</option>
	<option value="Jamaican">Jamaican</option>
	<option value="Japanese">Japanese</option>
	<option value="Jordanian">Jordanian</option>
	<option value="Kazakh">Kazakh</option>
	<option value="Kenyan">Kenyan</option>
	<option value="Kittitian">Kittitian</option>
	<option value="Kuwaiti">Kuwaiti</option>
	<option value="Kyrgyz">Kyrgyz</option>
	<option value="Laotian">Laotian</option>
	<option value="Latvian">Latvian</option>
	<option value="Lebanese">Lebanese</option>
	<option value="Liberian">Liberian</option>
	<option value="Libyan">Libyan</option>
	<option value="Liechtensteinish">Liechtensteinish</option>
	<option value="Lithuanian">Lithuanian</option>
	<option value="Luxembourgian">Luxembourgian</option>
	<option value="Macedonian">Macedonian</option>
	<option value="Malagasy">Malagasy</option>
	<option value="Malawian">Malawian</option>
	<option value="Malaysian">Malaysian</option>
	<option value="Maldivan">Maldivan</option>
	<option value="Malian">Malian</option>
	<option value="Maltese">Maltese</option>
	<option value="Marshallese">Marshallese</option>
	<option value="Mauritanian">Mauritanian</option>
	<option value="Mauritian">Mauritian</option>
	<option value="Mexican">Mexican</option>
	<option value="Micronesian">Micronesian</option>
	<option value="Moldovan">Moldovan</option>
	<option value="Monegasque">Monegasque</option>
	<option value="Mongolian">Mongolian</option>
	<option value="Montenegrin">Montenegrin</option>
	<option value="Montserratian">Montserratian</option>
	<option value="Morrocan">Morrocan</option>
	<option value="Mosotho">Mosotho</option>
	<option value="Mozambican">Mozambican</option>
	<option value="Namibian">Namibian</option>
	<option value="Nauruan">Nauruan</option>
	<option value="Nepalese">Nepalese</option>
	<option value="New Caledonian">New Caledonian</option>
	<option value="New Zealander">New Zealander</option>
	<option value="Ni-Vanuatu">Ni-Vanuatu</option>
	<option value="Nicaraguan">Nicaraguan</option>
	<option value="Nigerian">Nigerian</option>
	<option value="Nigerien">Nigerien</option>
	<option value="Niuean">Niuean</option>
	<option value="Norfolk Islander">Norfolk Islander</option>
	<option value="North Korean">North Korean</option>
	<option value="Norwegian">Norwegian</option>
	<option value="Omani">Omani</option>
	<option value="Other">Other</option>
	<option value="Pakistani">Pakistani</option>
	<option value="Palestinian">Palestinian</option>
	<option value="Palauan">Palauan</option>
	<option value="Panamanian">Panamanian</option>
	<option value="Papua New Guinean">Papua New Guinean</option>
	<option value="Paraguayan">Paraguayan</option>
	<option value="Peruvian">Peruvian</option>
	<option value="Polish">Polish</option>
	<option value="Portuguese">Portuguese</option>
	<option value="Puerto Rican">Puerto Rican</option>
	<option value="Qatari">Qatari</option>
	<option value="Romanian">Romanian</option>
	<option value="Russian">Russian</option>
	<option value="Rwandan">Rwandan</option>
	<option value="Saint Lucian">Saint Lucian</option>
	<option value="Salvadoran">Salvadoran</option>
	<option value="Sammarinese">Sammarinese</option>
	<option value="Samoan">Samoan</option>
	<option value="Sao Tomean">Sao Tomean</option>
	<option value="Saudi">Saudi</option>
	<option value="Scottish">Scottish</option>
	<option value="Senegalese">Senegalese</option>
	<option value="Serbian">Serbian</option>
	<option value="Seychellois">Seychellois</option>
	<option value="Sierra Leonean">Sierra Leonean</option>
	<option value="Singaporean">Singaporean</option>
	<option value="Slovakian">Slovakian</option>
	<option value="Slovenian">Slovenian</option>
	<option value="Solomon Islander">Solomon Islander</option>
	<option value="Somalian">Somalian</option>
	<option value="South African">South African</option>
	<option value="South Korean">South Korean</option>
	<option value="Spanish">Spanish</option>
	<option value="Sri Lankan">Sri Lankan</option>
	<option value="Sudanese">Sudanese</option>
	<option value="Surinamer">Surinamer</option>
	<option value="Swazi">Swazi</option>
	<option value="Swedish">Swedish</option>
	<option value="Swiss">Swiss</option>
	<option value="Syrian">Syrian</option>
	<option value="Taiwanese">Taiwanese</option>
	<option value="Tajik">Tajik</option>
	<option value="Tanzanian">Tanzanian</option>
	<option value="Thai">Thai</option>
	<option value="Togolese">Togolese</option>
	<option value="Tongan">Tongan</option>
	<option value="Trinidadian">Trinidadian</option>
	<option value="Tunisian">Tunisian</option>
	<option value="Turkish">Turkish</option>
	<option value="Turkmenistani">Turkmenistani</option>
	<option value="Ugandan">Ugandan</option>
	<option value="Ukrainian">Ukrainian</option>
	<option value="Uruguayan">Uruguayan</option>
	<option value="Uzbekistani">Uzbekistani</option>
	<option value="Venezuelan">Venezuelan</option>
	<option value="Vietnamese">Vietnamese</option>
	<option value="Welsh">Welsh</option>
	<option value="Yemeni">Yemeni</option>
	<option value="Zambian">Zambian</option>
	<option value="Zimbabwean">Zimbabwean</option>
	
	</aui:select>
	
	
		
		<aui:input name="dateOfBirth" type="text" id="dateOfBirth" label="Date of Birth" inlineLabel="true"></aui:input>
		<script type="text/javascript">
	jQuery(document).ready(
	function() {
	jQuery('#<portlet:namespace />dateOfBirth').datepicker();
	}
	);
	</script>  
</td>
<td>
	<div align="left"  class="HR_Heading2">Contact Information<br><br></div>
	
	<aui:input name="street1" id="street1" type="textarea" label="Street1" inlineLabel="true"></aui:input>
	<aui:input name="street2" id="street2" type="textarea" label="Street2" inlineLabel="true"></aui:input>
	<aui:input name="street3" id="street3" type="textarea" label="Street3" inlineLabel="true"></aui:input>
<%-- 	<aui:input name="zip" id="zip" type="text" label="ZipCode" inlineLabel="true"></aui:input> --%>

	<aui:input name="personalEmail" id="personalEmail" type="text" label="Email" inlineLabel="true"></aui:input>
	<aui:input name="city" id="city" type="text" label="City" inlineLabel="true"></aui:input>
	
	<aui:select id="country" class="WebHRForm1" name="country" label="Country" inlineLabel="true">
	<<c:forEach
	items="<%=CountryServiceUtil.getCountries() %>"
	var="country">
	<aui:option value="${country.countryId }" selected="${candidate.countryId == country.countryId? 'true' :'false'}">${country.name}</aui:option>
	</c:forEach>
	
			       </aui:select>
</td>
</tr>
<tr>
	<td>
	
	<div align="left"  class="HR_Heading2">Other Information<br><br></div>
		<aui:input name="currentCtc" id="currentCtc" type="text" label="Current Ctc" inlineLabel="true"></aui:input>

	<aui:input name="expectedCtc" id="expectedCtc" type="text" label="Expected Ctc" inlineLabel="true"></aui:input>
<aui:input name="noticePeriod" id="noticePeriod" type="text" label="Notice Period" inlineLabel="true"></aui:input>
	
<aui:select id="status" class="WebHRForm1"  name="status" label="Status" inlineLabel="true">
<option value="0" selected="true">Active</option>
<option value="1">Inactive</option>

</aui:select>

<aui:select id="shortListed" class="WebHRForm1"  name="shortListed" label="ShortListed" inlineLabel="true">
<option value="0" selected="true">No</option>
<option value="1">Yes</option>

</aui:select>

<aui:input type="file" name="file" id="file" label="Attach Resume" inlineLabel="true"/>
	</td>
	

</tr>
<tr>
	<td colspan="2" align="center"><aui:button type="submit" name="submit" value="Save" /></td>
</tr>
</aui:form>
</tbody>
</table>
