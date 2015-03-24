<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"%>
<%@taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@taglib prefix="liferay-util" uri="http://liferay.com/tld/util"%>
<%@taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>



<portlet:defineObjects />
<liferay-theme:defineObjects />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<%
	String employeeName = ParamUtil.getString(request, "employeeName");
	String attendanceDate = ParamUtil.getString(request,
			"attendanceDate");
	int attendanceDisplayMode = ParamUtil.getInteger(request,
			"attendanceDisplayMode");
	String attendanceQuarter = ParamUtil.getString(request,
			"attendanceQuarter");
	String attendanceMonth = ParamUtil.getString(request,
			"attendanceMonth");
	long employeeId = ParamUtil.getLong(request,
			"employeeId");
%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/custom.css" />
<script src="<%=request.getContextPath()%>/js/custom.js"></script>