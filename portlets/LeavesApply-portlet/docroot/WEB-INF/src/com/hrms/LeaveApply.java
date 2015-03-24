package com.hrms;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@Controller("LeaveApply")
@RequestMapping("VIEW")
public class LeaveApply{
	@RequestMapping
	public String display(RenderRequest renderRequest,RenderResponse renderResponse,Model model){
		try{
			
		}
		catch(Exception e){
			
		}
		return "display";
		
	}
	
	@RenderMapping(params="action=apply")
	public String applyLeave(RenderRequest renderRequest,RenderResponse renderResponse,Model model){
		try{
			
		}
		catch(Exception e){
			
		}
		return "apply";
		
	}
	@ActionMapping(params="action=applyLeave")
	public void applyLeaveAction(@ModelAttribute("LeaveApply")LeaveApplyModel applyModel,ActionRequest actionRequest,ActionResponse actionResponse){
		try{
			
		}
		catch(Exception e){
			
		}
		actionResponse.setRenderParameter("action", "display");
		
	}
	
}
