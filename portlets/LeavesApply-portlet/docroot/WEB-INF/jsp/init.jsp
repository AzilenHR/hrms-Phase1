<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.hrms.service.LeaveLocalServiceUtil" %>
<%@page import="com.hrms.model.Leave" %>
<%@page import="java.util.List" %>
<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%
	String employeeName=ParamUtil.getString(request, "employeeName");
	String leaveName=ParamUtil.getString(request, "leaveName");
	String entitlement=ParamUtil.getString(request, "entitlement");
	String leaveDuration=ParamUtil.getString(request, "leaveDuration");
	


%>