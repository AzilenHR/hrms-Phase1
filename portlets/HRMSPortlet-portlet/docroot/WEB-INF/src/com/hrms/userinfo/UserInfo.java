package com.hrms.userinfo;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class UserInfo  {

	@RenderMapping	
		public String defaultRenderMapping(RenderRequest renderRequest,RenderResponse renderResponse)
			{
				return "view";
			}

}
