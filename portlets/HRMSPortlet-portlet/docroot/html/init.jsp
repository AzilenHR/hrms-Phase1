<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.hrms.model.EmployeeMst"%>
<%@ page import="java.util.Iterator" %>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />