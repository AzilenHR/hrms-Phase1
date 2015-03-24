package com.hrms;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.hrms.model.EmployeeDepartment;
import com.hrms.model.Leave;
import com.hrms.model.impl.LeaveImpl;
import com.hrms.service.EmployeeDepartmentLocalServiceUtil;
import com.hrms.service.LeaveLocalServiceUtil;
import com.hrms.service.LeaveServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Http.Response;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

@Controller("LeaveManage")
@RequestMapping("VIEW")
public class LeaveManage{
	
	private static final Log LOG = LogFactoryUtil
			.getLog(Leave.class);
	
	@RequestMapping
	public String displayPage(RenderRequest request,RenderResponse response,Model model){
		try{
			
			
		}
		catch(Exception e){
			}
		return "display";
		
	}
	@RenderMapping(params="action=add")
	public String addLeave(RenderRequest request,RenderResponse response,Model model){
		try{
			
		}
		catch(Exception e){
		}
		return "add";
		
	}
	@RenderMapping(params="action=displayURL")
	public String displayURL(RenderRequest request,RenderResponse response,Model model){
		try{
			
		}
		catch(Exception e){
			}
		return "display";
		
	}
	@RenderMapping(params="action=editleaveURL")
	public String editLeave(RenderRequest request,RenderResponse response,Model model){
		
	
		try{
			long leaveId=ParamUtil.getLong(request, "ID");
			System.out.println("leave id  in render is:" +leaveId);
			Leave leave=LeaveLocalServiceUtil.getLeave(leaveId);
			request.setAttribute("leave", leave);
			System.out.println(leave);
			System.out.println("edit render");
		
		}
		catch(Exception e){
			
		}
		return "edit";
		
	}
//	@RenderMapping(params="action=deleteleaveURL")
//	public String deleteLeave(RenderRequest request,RenderResponse response,Model model){
//		try{
//			System.out.println(" del");
//		}
//		catch(Exception  e){
//			
//		}
//		return "display";
//		
//	}
//	@ModelAttribute("leave")
//	public Leave getLeaveObject(){
//		try{
//			System.out.println("ModelAttribute" );
//		}
//		catch(Exception e){
//			
//		}
//		return new LeaveImpl();
//	}
	@ActionMapping(params="action=addURL")
	public void addURL(@ModelAttribute("LeaveFm") LeaveModel leaveModel,ActionRequest request,ActionResponse response) throws SystemException,PortletException, PortalException{
		
		try{
			
			long leaveId=ParamUtil.getLong(request, "ID");
			System.out.println("leaveId of leave is"+leaveId);
			long Status=ParamUtil.getLong(request, "Status");
		
			if(leaveId != 0){
			System.out.println("edit method");
				Leave leave=LeaveLocalServiceUtil.getLeave(leaveId);
				leave.setLeaveName(leaveModel.getLeaveName());
				leave.setLeavesAllowedPerYear(Integer.valueOf(leaveModel.getLeavesAllowedPerYear()));
				leave.setLeaveType(leaveModel.getLeaveType());
				leave.setCarryOver(Boolean.valueOf(leaveModel.getCarryOver()));
				leave.setCarryOverLimit(leaveModel.getCarryOverLimit());
				leave.setEncachement(Boolean.valueOf(leaveModel.getEncachement()));
				leave.setStatus(Boolean.valueOf(leaveModel.getStatus()));
				
				Date date = new Date();
				System.out.println(date);
				leave.setModifiedDate(date);
				ServiceContext serviceContext = null;
				serviceContext = ServiceContextFactory.getInstance(
				Leave.class.getName(), request);
				leave.setModifiedBy(serviceContext.getUserId());
				long modifiedByUserId=leave.getModifiedBy();
				System.out.println(UserLocalServiceUtil.getUserById(modifiedByUserId));
				
				LeaveLocalServiceUtil.updateLeave(leave);
				SessionMessages.add(request.getPortletSession(), "leave-update-successfully");
				LOG.info("leave-update");
//				long leaveId=CounterLocalServiceUtil.increment(LeaveImpl.class.getName());			
//				l=LeaveLocalServiceUtil.createLeave(CounterLocalServiceUtil.increment(LeaveImpl.class.getName()));
//				l.setLeaveName(leaveImpl.getLeaveName());
//				l.setLeavesAllowedPerYear(leaveImpl.getLeavesAllowedPerYear());
//				l.setLeaveType(leaveImpl.getLeaveType());
//				l.setCarryOver(leaveImpl.getCarryOver());
//				l.setEncachement(leaveImpl.getEncachement());
//				l.setStatus(leaveImpl.getStatus());
//				Date date = new Date();
//				System.out.println(date);
//				l.setCreateDate(date);
//				ServiceContext serviceContext = null;
//				serviceContext = ServiceContextFactory.getInstance(
//				Leave.class.getName(),request);
//				l.setCreateBy(serviceContext.getUserId());
//		    	long createByuserId=l.getCreateBy();
//		    	System.out.println(UserLocalServiceUtil.getUserById(createByuserId));
//		    	LeaveLocalServiceUtil.addLeave(l);
//		    	SessionMessages.add(request.getPortletSession(), "leave-added-successfully");
//		    	LOG.info("add-leave");
			}
			else{
				System.out.println("add method");
				leaveId=CounterLocalServiceUtil.increment(Leave.class.getName());
				Leave leave=LeaveLocalServiceUtil.createLeave(leaveId);
				
				leave.setLeaveName(leaveModel.getLeaveName());
				leave.setLeavesAllowedPerYear(Integer.valueOf(leaveModel.getLeavesAllowedPerYear()));
				leave.setLeaveType(leaveModel.getLeaveType());
				leave.setCarryOver(Boolean.valueOf(leaveModel.getCarryOver()));
				leave.setEncachement(Boolean.valueOf(leaveModel.getEncachement()));
				leave.setStatus(Boolean.valueOf(leaveModel.getStatus()));
				System.out.println("leavename of leave---"+leaveModel.getLeaveName());
				leave.setCarryOver(leaveModel.getCarryOver());
				leave.setCarryOverLimit(leaveModel.getCarryOverLimit());
				leave.setEncachement(leaveModel.getEncachement());
				leave.setStatus(Boolean.valueOf(leaveModel.getStatus()));
				
				Date date = new Date();
				System.out.println(date);
				leave.setCreateDate(date);
				ServiceContext serviceContext = null;
				serviceContext = ServiceContextFactory.getInstance(
				Leave.class.getName(),request);
				leave.setCreateBy(serviceContext.getUserId());
		    	long createByuserId=leave.getCreateBy();
		    	System.out.println(leave+" leave");
				LeaveLocalServiceUtil.addLeave(leave);
				SessionMessages.add(request.getPortletSession(), "leave-added-successfully");
				LOG.info("add-leave");
			}	
		}
		catch(Exception e){
			SessionMessages.add(request.getPortletSession(), "leave-add-error");
			e.printStackTrace();
		}
		response.setRenderParameter("action", "displayURL");
	}

//	@ActionMapping(params="action=editURL")
//	public void editURL(@ModelAttribute("leave") Leave leaveImpl,ActionRequest request,ActionResponse response) throws PortalException, SystemException{
////		System.out.println("edit");
//				Leave l=new LeaveImpl();
//				long leaveId=Long.parseLong(request.getParameter("ID"));
//				System.out.println("ID is--"+leaveId);
//				//long id=leaveImpl.getLeaveId();
//				 l=LeaveLocalServiceUtil.getLeave(leaveId);
//				System.out.println(" edit act" +l);
//			try{
//				if(leaveImpl.getLeaveName()!=null)
//				{
//					System.out.println("ID is--"+leaveId);
//						l.setLeaveName(leaveImpl.getLeaveName());
//						l.setLeavesAllowedPerYear(leaveImpl.getLeavesAllowedPerYear());
//						l.setLeaveType(leaveImpl.getLeaveType());
//						l.setCarryOver(leaveImpl.getCarryOver());
//						l.setEncachement(leaveImpl.getEncachement());
//						l.setStatus(leaveImpl.getStatus());
//						Date date = new Date();
//						System.out.println(date);
//						l.setModifiedDate(date);
//						ServiceContext serviceContext = null;
//						serviceContext = ServiceContextFactory.getInstance(
//						Leave.class.getName(), request);
//						l.setModifiedBy(serviceContext.getUserId());
//						long modifiedByUserId=l.getModifiedBy();
//						System.out.println(UserLocalServiceUtil.getUserById(modifiedByUserId));
//						LeaveLocalServiceUtil.updateLeave(l);
//						SessionMessages.add(request.getPortletSession(), "leave-update-successfully");
//						LOG.info("leave-update");
//				}
//			}
//			catch(Exception e){
//				SessionMessages.add(request.getPortletSession(), "leave-update-error");
//				e.printStackTrace();
//			}
//		response.setRenderParameter("action", "displayURL");
//	}
//	
	
}