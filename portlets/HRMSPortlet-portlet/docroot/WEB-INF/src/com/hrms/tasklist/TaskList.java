
package com.hrms.tasklist;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.hrms.model.Todo;
import com.hrms.service.TodoLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;




@Controller
@RequestMapping("VIEW")
public class TaskList {
 
	@RenderMapping
	public ModelAndView defaultRenderMethod(RenderRequest renderRequest, RenderResponse renderResponse) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId=themeDisplay.getUserId();
		List<Todo> taskList = TodoLocalServiceUtil.findUserById(userId);
		
		System.out.println("here is the list");
		System.out.println(taskList);
		ModelAndView md = new ModelAndView("view");
		md.addObject("taskList", taskList);
		return md;
	}
	

}