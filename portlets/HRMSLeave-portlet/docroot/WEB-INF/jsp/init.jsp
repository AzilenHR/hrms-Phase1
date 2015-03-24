<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.hrms.model.Leave" %>
<%@page import="com.hrms.service.LeaveLocalServiceUtil" %>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.hrms.model.impl.LeaveImpl"%>
<%@page import="com.hrms.service.impl.LeaveServiceImpl"%>
<%@page import="com.hrms.service.LeaveServiceUtil"%>
<%@page import="com.hrms.model.Leave"%>
<%@page import="com.hrms.service.LeaveLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %> 
 <%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%

	long leaveId=ParamUtil.getLong(request, "leaveId");
	String currentURL=PortalUtil.getCurrentURL(request);
	String leaveName=ParamUtil.getString(request, "leaveName");
	String leaveType=ParamUtil.getString(request, "leaveType");
	int leavesAllowedPerYear=ParamUtil.getInteger(request, "leavesAllowedPerYear");
	Boolean carryOver=ParamUtil.getBoolean(request, "carryOver");
	Boolean encachement=ParamUtil.getBoolean(request, "encachement");
	Boolean Status=ParamUtil.getBoolean(request, "Status");
	
%>
