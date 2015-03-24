<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.hrms.service.EmployeeDepartmentLocalServiceUtil"%>
<%@page import="com.hrms.service.EmployeeDesignationLocalServiceUtil"%>
<%@page import="com.hrms.service.EmployeeMstLocalServiceUtil"%>
<%@page import="com.hrms.model.EmployeeDepartmentModel"%>
<%@page import="com.hrms.model.EmployeeDepartment"%>
<%@page import="com.hrms.model.JobLibrary"%>
<%@page import="com.hrms.model.Candidate"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.service.JobLibraryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil" %>
<%@page import="java.util.Locale"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />


<% 
 	long candidateId = ParamUtil.getLong(request,"candidateId");
	String title = ParamUtil.getString(request, "title");
	String firstName = ParamUtil.getString(request, "firstName");
	String middleName = ParamUtil.getString(request, "middleName");
	
	
%>