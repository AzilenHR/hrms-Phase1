package com.hrms.Calendar;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.hrms.model.Todo;
import com.hrms.service.TodoLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping("VIEW")
public class Calendar {
	@RenderMapping
	public String defaultRender(RenderRequest req, RenderResponse res) {
		return "view";
	}

	@ActionMapping(params = "action=addTask")
	public void addTaskRender(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException {
		System.out.println("In action mapping");
		String date = ParamUtil.getString(actionRequest, "date");
		System.out.println(date);
		String task = ParamUtil.getString(actionRequest, "task");
		System.out.println(task);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Todo td = TodoLocalServiceUtil.createTodo(CounterLocalServiceUtil
				.increment());
		td.setUserId(userId);
		td.setDate(date);
		td.setTaskDetails(task);
		TodoLocalServiceUtil.addTodo(td);

	}

	@ResourceMapping(value = "saveTask")
	public void saveTask(ResourceRequest request, ResourceResponse response)
			throws IOException {

		HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));
		String msg = ParamUtil.getString(httpServletRequest, "msg");
		JSONObject json = JSONFactoryUtil.createJSONObject();

		System.out.println("msg ::: " + msg);

		System.out.println("In action mapping");
		String date = ParamUtil.getString(request, "date");
		System.out.println("date"+date);
		String task = ParamUtil.getString(request, "task");
		System.out.println("task"+task);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			Todo td = TodoLocalServiceUtil.createTodo(CounterLocalServiceUtil
					.increment());
			td.setUserId(userId);
			td.setDate(date);
			td.setTaskDetails(task);
			TodoLocalServiceUtil.addTodo(td);
			response.setCharacterEncoding("UTF-8");
			
			List<Todo> todos = TodoLocalServiceUtil.getTodos(-1, -1);
			
			 JSONObject responseDetailsJson = JSONFactoryUtil.createJSONObject();
			 JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			 for(Todo r : todos){
				 JSONObject formDetailsJson = JSONFactoryUtil.createJSONObject();
				 formDetailsJson.put("date", r.getDate());
				 formDetailsJson.put("detail", r.getTaskDetails());
				 jsonArray.put(formDetailsJson);
			 }
		    responseDetailsJson.put("forms", jsonArray);
			response.getWriter().write(responseDetailsJson.toString());
			System.out.println(responseDetailsJson.toString());
			response.getWriter().write(responseDetailsJson.toString());
			
		} catch (Exception e) {
			json.put("msg", "error");
			e.printStackTrace();
		}

	}

}
