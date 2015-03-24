<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/portlet/login/init.jsp"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:defineObjects />
<%--  <%=PortalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay) %> --%>


<portlet:renderURL var="forgotPasswordURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage" value="forgot_password.jsp" />
</portlet:renderURL>


<style>
<!--
-->
#_58_login, #_58_password {
	background-color: #9a9a9a;
	color: #ffffff;
	border: 1px solid #7a7a7a;
	box-shadow: 1px 1px 2px rgba(200, 200, 200, 0.2);
	width: 250px;
	font-size: 16px;
}

#heading {
	width: 310px;
}

.site-title {
	position: relative;
	left: 517px;
	top: 81px;
}

div.button-holder {
	position: relative;
	top: -45px;
	left: 204px;
}

div.portlet-content {
	position: absolute;
	left: 540px;
	top: 210px;
}

label.control-label {
	color: #fff;
}
</style>
<c:choose>
	<c:when test="<%=themeDisplay.isSignedIn()%>">

		<%
			String signedInAs = HtmlUtil.escape(user.getFullName());

					if (themeDisplay.isShowMyAccountIcon()
							&& (themeDisplay.getURLMyAccount() != null)) {
						String myAccountURL = String.valueOf(themeDisplay
								.getURLMyAccount());

						if (PropsValues.DOCKBAR_ADMINISTRATIVE_LINKS_SHOW_IN_POP_UP) {
							signedInAs = "<a class=\"signed-in\" href=\"javascript:Liferay.Util.openWindow({dialog: {destroyOnHide: true}, title: '"
									+ HtmlUtil.escapeJS(LanguageUtil.get(
											pageContext, "my-account"))
									+ "', uri: '"
									+ HtmlUtil.escapeJS(myAccountURL)
									+ "'});\">" + signedInAs + "</a>";
						} else {
							myAccountURL = HttpUtil.setParameter(myAccountURL,
									"controlPanelCategory",
									PortletCategoryKeys.MY);

							signedInAs = "<a class=\"signed-in\" href=\""
									+ HtmlUtil.escape(myAccountURL) + "\">"
									+ signedInAs + "</a>";
						}
					}
		%>

		<%=LanguageUtil.format(pageContext,
							"you-are-signed-in-as-x", signedInAs, false)%>
	</c:when>
	<c:otherwise>

		<%
			String redirect = ParamUtil.getString(request, "redirect");

					String login = LoginUtil
							.getLogin(request, "login", company);
					String password = StringPool.BLANK;
					boolean rememberMe = ParamUtil.getBoolean(request,
							"rememberMe");

					if (Validator.isNull(authType)) {
						authType = company.getAuthType();
					}
		%>

		<portlet:actionURL
			secure="<%=PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS
								|| request.isSecure()%>"
			var="loginURL">
			<portlet:param name="struts_action" value="/login/login" />
		</portlet:actionURL>

		<aui:form action="<%=loginURL%>"
			autocomplete='<%=PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE
								? "on"
								: "off"%>'
			cssClass="sign-in-form" method="post" name="fm">

			<aui:input name="saveLastPath" type="hidden" value="<%=false%>" />
			<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
			<aui:input name="doActionAfterLogin" type="hidden"
				value="<%=portletName.equals(PortletKeys.FAST_LOGIN)
								? true
								: false%>" />

			<c:choose>
				<c:when test='<%=SessionMessages.contains(request,
										"userAdded")%>'>

					<%
						String userEmailAddress = (String) SessionMessages
													.get(request, "userAdded");
											String userPassword = (String) SessionMessages
													.get(request, "userAddedPassword");
					%>

					<div class="alert alert-success">
						<c:choose>
							<c:when
								test="<%=company.isStrangersVerify()
												|| Validator
														.isNull(userPassword)%>">
								<%=LanguageUtil
												.get(pageContext,
														"thank-you-for-creating-an-account")%>

								<c:if test="<%=company
													.isStrangersVerify()%>">
									<%=LanguageUtil
													.format(pageContext,
															"your-email-verification-code-has-been-sent-to-x",
															userEmailAddress)%>
								</c:if>
							</c:when>
							<c:otherwise>
								<%=LanguageUtil
												.format(pageContext,
														"thank-you-for-creating-an-account.-your-password-is-x",
														userPassword, false)%>
							</c:otherwise>
						</c:choose>

						<c:if
							test="<%=PrefsPropsUtil.getBoolean(
											company.getCompanyId(),
											PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED)%>">
							<%=LanguageUtil.format(pageContext,
											"your-password-has-been-sent-to-x",
											userEmailAddress)%>
						</c:if>
					</div>
				</c:when>
				<c:when
					test='<%=SessionMessages.contains(request,
										"userPending")%>'>

					<%
						String userEmailAddress = (String) SessionMessages
													.get(request, "userPending");
					%>

					<div class="alert alert-success">
						<%=LanguageUtil
										.format(pageContext,
												"thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved",
												userEmailAddress)%>
					</div>
				</c:when>
			</c:choose>

			<liferay-ui:error exception="<%=AuthException.class%>"
				message="authentication-failed" />
			<liferay-ui:error exception="<%=CompanyMaxUsersException.class%>"
				message="unable-to-login-because-the-maximum-number-of-users-has-been-reached" />
			<liferay-ui:error
				exception="<%=CookieNotSupportedException.class%>"
				message="authentication-failed-please-enable-browser-cookies" />
			<liferay-ui:error exception="<%=NoSuchUserException.class%>"
				message="authentication-failed" />
			<liferay-ui:error exception="<%=PasswordExpiredException.class%>"
				message="your-password-has-expired" />
			<liferay-ui:error exception="<%=UserEmailAddressException.class%>"
				message="authentication-failed" />
			<liferay-ui:error exception="<%=UserLockoutException.class%>"
				message="this-account-has-been-locked" />
			<liferay-ui:error exception="<%=UserPasswordException.class%>"
				message="authentication-failed" />
			<liferay-ui:error exception="<%=UserScreenNameException.class%>"
				message="authentication-failed" />

			<aui:fieldset>

				<%
					String loginLabel = null;

									if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
										loginLabel = "username";
									} else if (authType
											.equals(CompanyConstants.AUTH_TYPE_SN)) {
										loginLabel = "screen-name";
									} else if (authType
											.equals(CompanyConstants.AUTH_TYPE_ID)) {
										loginLabel = "id";
									}
				%>

				<aui:input
					autoFocus="<%=windowState
										.equals(LiferayWindowState.EXCLUSIVE)
										|| windowState
												.equals(WindowState.MAXIMIZED)%>"
					cssClass="clearable" label="<%=loginLabel%>" name="login"
					showRequiredLabel="<%=false%>" type="text" value="<%=login%>">
					<aui:validator name="required" />
				</aui:input>

				<aui:input name="password" showRequiredLabel="<%=false%>"
					type="password" value="<%=password%>">
					<aui:validator name="required" />
				</aui:input>

				<span id="<portlet:namespace />passwordCapsLockSpan"
					style="display: none;"><liferay-ui:message
						key="caps-lock-is-on" /></span>

				<c:if
					test="<%=company.isAutoLogin()
										&& !PropsValues.SESSION_DISABLED%>">
					<aui:input checked="<%=rememberMe%>" name="rememberMe"
						type="checkbox" />
				</c:if>
				<aui:button-row>
					<aui:button cssClass="LogInButton" type="submit" value="sign-in" />
				</aui:button-row>
				<aui:a href="#" class="forgot_password" id="forgot_password" >Forgot Password</aui:a>
 
			</aui:fieldset>


		</aui:form>

	</c:otherwise>
</c:choose>


<aui:script>
var forgotPassword_popup;
 AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
  
    A.one('#<portlet:namespace/>forgot_password').on('click', function(event){
    forgotPassword_popup= Liferay.Util.Window.getWindow(
                {
                    dialog: {
                        centered: true,
                        constrain2view: true,
                        modal: true,
                        resizable: false,
                        width: 475,
                        id: "forgotPwdId",
                        name: "forgotPwdId"
                    } 
                }).plug(A.Plugin.DialogIframe,
                     {
                     autoLoad: true,
                     iframeCssClass: 'dialog-iframe',
                     uri:'http://localhost:8080/web/test1/login?p_p_id=58&p_p_lifecycle=0&p_p_state=pop_up&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Fforgot_password'
                     }).render();
             forgotPassword_popup.show();
                    forgotPassword_popup.titleNode.html("Forgot Password");
                    
 
     });
     
 });
 
 </aui:script>




