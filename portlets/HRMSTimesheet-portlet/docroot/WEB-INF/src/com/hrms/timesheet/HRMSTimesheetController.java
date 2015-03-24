package com.hrms.timesheet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.hrms.model.EmployeeTimesheet;
import com.hrms.service.EmployeeAttendanceLocalServiceUtil;
import com.hrms.service.EmployeeTimesheetLocalServiceUtil;
import com.hrms.timesheet.model.TimesheetModel;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class HRMSTimesheetController
 */

@RequestMapping("VIEW")
@Controller
public class HRMSTimesheetController {

	@RenderMapping
	public ModelAndView view(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		return new ModelAndView("view");
	}

	@RenderMapping(params = "render=addTimesheet")
	public ModelAndView addTimesheet(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		ModelAndView modelAndView = new ModelAndView("AddTimesheet");
		return modelAndView;
	}

	@ActionMapping(params = "action=createTimesheet")
	public void createTimesheet(
			ActionRequest actionRequest,
			ActionResponse actionResponse,
			@ModelAttribute(value = "timesheetForm") TimesheetModel timesheetModel)
			throws SystemException, PortalException, ParseException {
		long employeeTimesheetId = CounterLocalServiceUtil
				.increment(EmployeeTimesheet.class.getName());
		EmployeeTimesheet employeeTimesheet = EmployeeTimesheetLocalServiceUtil
				.createEmployeeTimesheet(employeeTimesheetId);

		// Basic Details of the Timesheets

		employeeTimesheet.setTaskTitle(timesheetModel.getTaskTitle());
		employeeTimesheet.setTaskDescription(timesheetModel
				.getTaskDescription());
		SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy",
				Locale.ENGLISH);
		employeeTimesheet.setTaskDate(formatter.parse(timesheetModel
				.getTaskDate()));

		employeeTimesheet.setTaskStarttime(new Date(timesheetModel
				.getTaskDate() + " " + timesheetModel.getStarttime()));
		employeeTimesheet.setTaskEndtime(new Date(timesheetModel.getTaskDate()
				+ " " + timesheetModel.getEndtime()));
		employeeTimesheet.setDuration(timesheetModel.getDuration());

		employeeTimesheet.setBillable(timesheetModel.isBillable());
		employeeTimesheet.setBilled(false);
		employeeTimesheet.setTaskCompleted(timesheetModel.isTaskCompleted());

		// Details related to the audit fields .
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		employeeTimesheet.setUserId(userId);
		employeeTimesheet.setCompanyId(themeDisplay.getCompanyId());
		employeeTimesheet.setGroupId(themeDisplay.getCompany().getGroupId());
		employeeTimesheet.setCreateBy(userId);
		employeeTimesheet.setCreateDate(new Date());

		EmployeeTimesheetLocalServiceUtil
				.addEmployeeTimesheet(employeeTimesheet);

		EmployeeAttendanceLocalServiceUtil.manageAttendance(employeeTimesheet);
	}

	@ActionMapping(params = "action=deleteTimesheet")
	public void deleteTimesheet(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		long timesheetId = ParamUtil.getLong(actionRequest, "timesheetId");
		EmployeeTimesheetLocalServiceUtil.deleteEmployeeTimesheet(timesheetId);
	}

	@RenderMapping(params = "render=editTimesheet")
	public ModelAndView editTimesheet(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortalException,
			SystemException {
		ModelAndView model = new ModelAndView("AddTimesheet");
		long timesheetId = ParamUtil.getLong(renderRequest, "timesheetId");
		EmployeeTimesheet employeeTimesheet = EmployeeTimesheetLocalServiceUtil
				.getEmployeeTimesheet(timesheetId);
		model.addObject("empTimesheet", employeeTimesheet);
		return model;
	}

	@ActionMapping(params = "action=updateTimesheet")
	public void updateTimesheet(
			ActionRequest actionRequest,
			ActionResponse actionResponse,
			@ModelAttribute(value = "timesheetForm") TimesheetModel timesheetModel)
			throws PortalException, SystemException {
		long timesheetId = ParamUtil.getLong(actionRequest, "timesheetId");
		EmployeeTimesheet employeeTimesheet = null;
		if (timesheetId > 0) {
			employeeTimesheet = EmployeeTimesheetLocalServiceUtil
					.getEmployeeTimesheet(timesheetId);

			employeeTimesheet.setTaskTitle(timesheetModel.getTaskTitle());
			employeeTimesheet
					.setTaskDescription(timesheetModel.getTaskDescription());
			employeeTimesheet.setTaskDate(new Date(timesheetModel.getTaskDate()));

			employeeTimesheet.setTaskStarttime(new Date(timesheetModel.getTaskDate()
					+ " " + timesheetModel.getStarttime()));
			employeeTimesheet.setTaskEndtime(new Date(timesheetModel.getTaskDate()
					+ " " + timesheetModel.getEndtime()));
			employeeTimesheet.setDuration(timesheetModel.getDuration());

			employeeTimesheet.setBillable(timesheetModel.isBillable());
			employeeTimesheet.setBilled(false);
			employeeTimesheet.setTaskCompleted(timesheetModel.isTaskCompleted());

			// Code for file is appended later.

			// Details related to the audit fields .
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			employeeTimesheet.setModifiedBy(userId);
			employeeTimesheet.setModifiedDate(new Date());

			EmployeeTimesheetLocalServiceUtil
					.updateEmployeeTimesheet(employeeTimesheet);
			
			EmployeeAttendanceLocalServiceUtil.manageAttendance(employeeTimesheet);
		}
	}

	@ActionMapping(params = "action=completeTimesheetTask")
	public void completeTimesheetTask(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		long timesheetId = ParamUtil.getLong(actionRequest, "timesheetId");
		EmployeeTimesheet employeeTimesheet = EmployeeTimesheetLocalServiceUtil
				.getEmployeeTimesheet(timesheetId);
		employeeTimesheet.setTaskCompleted(true);
		EmployeeTimesheetLocalServiceUtil.updateEmployeeTimesheet(employeeTimesheet);
	}
}
