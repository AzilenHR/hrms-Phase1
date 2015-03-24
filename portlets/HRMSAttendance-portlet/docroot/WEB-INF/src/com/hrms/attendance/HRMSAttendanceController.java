package com.hrms.attendance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.hrms.model.EmployeeAttendance;
import com.hrms.service.EmployeeAttendanceLocalServiceUtil;
import com.hrms.service.EmployeeMstLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;

/**
 * Portlet implementation class HRMSAttendanceController
 */

@Controller
@RequestMapping("VIEW")
public class HRMSAttendanceController {

	@RenderMapping
	public ModelAndView view(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		return new ModelAndView("view");
	}

	@ActionMapping(params = "action=approveAttendance")
	public void approveAttendance(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		long attendanceId = ParamUtil.getLong(actionRequest, "attendanceId");
		EmployeeAttendance employeeAttendance = EmployeeAttendanceLocalServiceUtil
				.getEmployeeAttendance(attendanceId);
		employeeAttendance.setApproved(true);
		EmployeeAttendanceLocalServiceUtil
				.updateEmployeeAttendance(employeeAttendance);
	}

	@ResourceMapping
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException,
			JSONException, IOException {
		boolean employeeSearchMode = ParamUtil.getBoolean(resourceRequest,
				"employeeSearchMode");
		if (employeeSearchMode) {
			getEmployeesByKeywords(resourceRequest, resourceResponse);
		}
	}

	private void getEmployeesByKeywords(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException,
			JSONException, IOException {
		String searchKeywords = ParamUtil
				.getString(resourceRequest, "keywords");

		List<User> userList = EmployeeMstLocalServiceUtil
				.getEmployeesByKeywords(searchKeywords);

		JSONObject responseDetailsJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		List<UserModel> userModelList = new ArrayList<UserModel>();

		for (User user : userList) {
			JSONObject formDetailsJson = JSONFactoryUtil.createJSONObject();
			formDetailsJson.put("userId", user.getUserId());
			formDetailsJson.put("firstName", user.getFirstName());
			formDetailsJson.put("lastName", user.getLastName());
			formDetailsJson.put("fullName", user.getFullName());
			jsonArray.put(formDetailsJson);
		}
//		responseDetailsJson.put("users", jsonArray);
		
		resourceResponse.getWriter().write(jsonArray.toString());
	}
}