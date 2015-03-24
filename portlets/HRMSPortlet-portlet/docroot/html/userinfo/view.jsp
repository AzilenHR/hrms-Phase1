<%@page import="com.hrms.service.EmployeeMstLocalServiceUtil"%>
<%@page import="com.hrms.model.EmployeeMst"%>
<%@page import="com.hrms.service.EmployeeDepartmentLocalServiceUtil"%>
<%@page import="com.hrms.model.EmployeeDepartment"%>
<%@page import="com.hrms.service.EmployeeDesignationLocalServiceUtil"%>
<%@page import="com.hrms.model.EmployeeDesignation"%>
<%@page import="com.hrms.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="com.hrms.model.EmployeeType"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@include file="init.jsp"%>

<%
	ThemeDisplay themeDisplay = (ThemeDisplay) request
			.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = themeDisplay.getUserId();
	EmployeeMst empMaster = EmployeeMstLocalServiceUtil
			.findEmployeeByUserId(userId);
	User user = UserLocalServiceUtil.getUser(userId);
	String  empType =empMaster.getEmployeeType();
	EmployeeDesignation empDesignation = EmployeeDesignationLocalServiceUtil
			.getEmployeeDesignation(empMaster.getEmployeeDesignationId());
	EmployeeDepartment empDepartment = EmployeeDepartmentLocalServiceUtil
			.getEmployeeDepartment(empMaster.getEmployeeDepartmentId());
%>

My Information
<table>
	<tr>
		<td>Name</td>
		<td>:</td>
		<td><b>&nbsp<%=user.getFullName()%></b></td>
	</tr>
	<tr>
		<td>Employee Type</td>
		<td>:</td>
		<td><b>&nbsp<%=empType.toString()%></b></td>
	</tr>
	<tr>
		<td>Employee Category</td>
		<td>:</td>
		<td><b>&nbsp<%=empDesignation.getDesignationName()%></b></td>
	</tr>
	<tr>
		<td>Department</td>
		<td>:</td>
		<td><b>&nbsp<%=empDepartment.getDepartmentName()%></b></td>
	</tr>
	<tr>
		<td>Last Login</td>
		<td>:</td>
		<td><b>&nbsp<%=user.getLastLoginDate()%></b></td>
	</tr>
</table>
<div>