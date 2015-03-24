package com.hrms;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import com.hrms.model.JobLibrary;
import com.hrms.service.JobLibraryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

@Controller
@RequestMapping("VIEW")
public class RequisitionController {
	private static final Log LOG = LogFactoryUtil
			.getLog(JobLibrary.class);
	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response ) throws SystemException {
		System.out.println("handleRenderRequest");
		ModelAndView model = new ModelAndView("jobrequisitionview");
		List<JobLibrary> jobLibraryList = new ArrayList<JobLibrary>();
		jobLibraryList = JobLibraryLocalServiceUtil.getJobLibraries(0,JobLibraryLocalServiceUtil.getJobLibrariesCount() -1);
		model.addObject("jobLibraryList", jobLibraryList);
		return model;
	}
 	@RenderMapping(params = "render=createJobRequisition")
	public String createJobRequisition(RenderRequest renderRequest,
			RenderResponse renderResponse, Model model) {
		System.out.println("createJobRequisition");
		JobRequisitionModel joblibrarymodelview = new JobRequisitionModel();
		model.addAttribute("reg", joblibrarymodelview);
		return "createJobRequisition";
	}
	@ActionMapping(params = "action=addRequisition")
	public void addRequisition(@ModelAttribute("reg") JobRequisitionModel jobrequisitionmodel,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {
		try
		{
		long jobLibraryId = ParamUtil.getLong(actionRequest,"jobLibraryId");
		if(jobLibraryId != 0){
				System.out.println("hii");
				JobLibrary jb = JobLibraryLocalServiceUtil.getJobLibrary(jobLibraryId);
				jb.setEmployeeDepartmentId(jobrequisitionmodel.getEmployeeDepartmentId());
				jb.setJobTitle(jobrequisitionmodel.getJobTitle());
				jb.setJobDescription(jobrequisitionmodel.getJobDescription());
				jb.setResponsibility(jobrequisitionmodel.getResponsibility());
				jb.setQualifications(jobrequisitionmodel.getQualifications());
				jb.setNumberOfPosition(jobrequisitionmodel.getNumberOfPosition());
				jb.setExperience(jobrequisitionmodel.getExperience());
				jb.setSalaryStartRange(jobrequisitionmodel.getSalaryStartRange());
				jb.setSalaryEndRange(jobrequisitionmodel.getSalaryEndRange());
				jb.setBenefits(jobrequisitionmodel.getBenefits());
				jb.setReportsToId(jobrequisitionmodel.getReportsToId());
				
				Date date = new Date();
			    System.out.println(date);
			    	jb.setModifiedDate(date);
			 
			 ServiceContext serviceContext = null;
			serviceContext = ServiceContextFactory.getInstance(
							JobLibrary.class.getName(), actionRequest);

			jb.setModifiedBy(serviceContext.getUserId());
				
				JobLibraryLocalServiceUtil.updateJobLibrary(jb);
				System.out.println(jobrequisitionmodel.getJobTitle()+"--"+jobrequisitionmodel.getJobDescription()+"--"+jb);
				SessionMessages.add(actionRequest.getPortletSession(),"jobLibrary-update-success");
				LOG.info("Update");
			}
			else
			{
				jobLibraryId = CounterLocalServiceUtil.increment(JobLibrary.class.getName());
				JobLibrary jb= JobLibraryLocalServiceUtil.createJobLibrary(jobLibraryId);
				jb.setEmployeeDepartmentId(jobrequisitionmodel.getEmployeeDepartmentId());
					jb.setJobTitle(jobrequisitionmodel.getJobTitle());
					jb.setJobDescription(jobrequisitionmodel.getJobDescription());
					jb.setResponsibility(jobrequisitionmodel.getResponsibility());
					jb.setQualifications(jobrequisitionmodel.getQualifications());
					jb.setNumberOfPosition(jobrequisitionmodel.getNumberOfPosition());
					jb.setExperience(jobrequisitionmodel.getExperience());
					jb.setSalaryStartRange(jobrequisitionmodel.getSalaryStartRange());
					jb.setSalaryEndRange(jobrequisitionmodel.getSalaryEndRange());
					jb.setBenefits(jobrequisitionmodel.getBenefits());
					jb.setReportsToId(jobrequisitionmodel.getReportsToId());
				Date date = new Date();
				    System.out.println(date);
				    	jb.setCreateDate(date);
				ServiceContext serviceContext = null;
				serviceContext = ServiceContextFactory.getInstance(
								JobLibrary.class.getName(), actionRequest);
				jb.setCreateBy(serviceContext.getUserId());
				JobLibraryLocalServiceUtil.addJobLibrary(jb);
				System.out.println(jobrequisitionmodel.getJobTitle()+"--"+jobrequisitionmodel.getJobDescription()+"--"+jb);
				SessionMessages.add(actionRequest.getPortletSession(),
						"jobLibarary-add-success");
				LOG.info("jobLibarary Save");
			}
		}
		catch(Exception e)
		{
			SessionErrors.add(actionRequest.getPortletSession(),
					"jobLibarary-add-error");
			e.printStackTrace();
		}
			
	}
	@RenderMapping(params = "render=editJobLibraryDisplay")
	public ModelAndView editRequisition(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortalException,
			SystemException {
		ModelAndView modelAndView = new ModelAndView("createJobRequisition");
		try
		{
		long jobLibraryId = ParamUtil.getLong(renderRequest, "jobLibraryId");
			JobLibrary joblibrary = JobLibraryLocalServiceUtil.getJobLibrary(jobLibraryId);
			System.out.println(joblibrary);
			modelAndView.addObject("joblibrary", joblibrary);
		}
		catch(Exception e)
		{}
		return modelAndView;
	}
	@RenderMapping(params = "render=viewJobLibrary")
	public ModelAndView viewJobLibrary(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortalException,
			SystemException {
		ModelAndView modelAndView = new ModelAndView("viewRequisition");
		try
		{
		long jobLibraryId = ParamUtil.getLong(renderRequest, "jobLibraryId");
		JobLibrary joblibrary = JobLibraryLocalServiceUtil.getJobLibrary(jobLibraryId);
		System.out.println(joblibrary);
		modelAndView.addObject("joblibrary", joblibrary);
		}
		catch(Exception e)
		{}
		return modelAndView;
	}
	@ActionMapping(params = "action=deleteJobLibrary")
	public void deleteJobLibrary(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		try
		{
		long jobLibraryId = ParamUtil.getLong(actionRequest, "jobLibraryId");
		System.out.println(jobLibraryId);
		JobLibraryLocalServiceUtil.deleteJobLibrary(jobLibraryId);
		System.out.println("deleted");
		SessionMessages.add(actionRequest.getPortletSession(),"jobLibrary-delete-success");
		LOG.info("Delete");
		}
		catch(Exception e)
		{
			SessionErrors.add(actionRequest.getPortletSession(),
					"jobLibrary-delete-error");
			e.printStackTrace();
		}
	}
}


