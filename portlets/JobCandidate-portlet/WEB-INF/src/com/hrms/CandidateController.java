package com.hrms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.hrms.model.Candidate;
import com.hrms.model.EmployeeDepartment;
import com.hrms.model.JobLibrary;
import com.hrms.service.CandidateLocalServiceUtil;
import com.hrms.service.EmployeeDepartmentLocalServiceUtil;
import com.hrms.service.JobLibraryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

@Controller
@RequestMapping("VIEW")
public class CandidateController {
	Log LOG = LogFactoryUtil.getLog(Candidate.class);
	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response ) throws SystemException {
		System.out.println("handleRenderRequest");
		ModelAndView model = new ModelAndView("view");
		List<Candidate> candidateList = new ArrayList<Candidate>();
		candidateList = CandidateLocalServiceUtil.getCandidates(0,CandidateLocalServiceUtil.getCandidatesCount() -1);
		model.addObject("candidateList", candidateList);
		return model;
	}
	
	@RenderMapping(params = "render=create")
	public String view(RenderRequest renderRequest,
			RenderResponse renderResponse, ModelMap model) throws SystemException {
		CandidateModel candidatemodelview = new CandidateModel();
		        model.addAttribute("candidateModel", candidatemodelview);
		        
		
		model.addAttribute("country",CountryServiceUtil.getCountries());
		model.addAttribute("candidateModel", new  CandidateModel());
		System.out.println(CountryServiceUtil.getCountries()+ " cou");
		return "createcandidate";
	}

	@ActionMapping(params = "action=addCandidate")
	public void addCandidate(
			@ModelAttribute("candidateModel") CandidateModel candidateModeldata,
			ActionRequest actionRequest,ActionResponse actionresponse)
			throws SystemException, PortalException, FileNotFoundException, ParseException {
		long candidateId=ParamUtil.getLong(actionRequest, "candidateId");
		System.out.println(candidateId);
		if(candidateId != 0)
		{
			Candidate candidate = CandidateLocalServiceUtil.getCandidate(candidateId);
			candidate.setEmployeeDepartmentId(candidateModeldata.getEmployeeDepartmentId());
			candidate.setEmployeeSubDepartmentId(candidateModeldata.getEmployeeSubDepartmentId());
			candidate.setEmployeeDesignationId(candidateModeldata.getEmployeeDesignationId());
			candidate.setTitle(candidateModeldata.getTitle());
			candidate.setFirstName(candidateModeldata.getFirstName());System.out.println(candidateModeldata.getFirstName()+" fname");
			candidate.setMiddleName(candidateModeldata.getMiddleName());
			candidate.setLastName(candidateModeldata.getLastName());
			candidate.setGender(candidateModeldata.getGender());
			candidate.setNationality(candidateModeldata.getNationality());
			candidate.setCity(candidateModeldata.getCity());
			candidate.setCountryId(candidateModeldata.getCountryId());
			candidate.setStreet1(candidateModeldata.getStreet1());
			candidate.setStreet2(candidateModeldata.getStreet2());
			candidate.setStreet3(candidateModeldata.getStreet3());
			candidate.setEmployeeProofId(candidateModeldata.getEmployeeProofId());
			candidate.setCurrentCtc(candidateModeldata.getCurrentCtc());
			candidate.setShortListed(candidateModeldata.isShortListed());
			candidate.setStatus(candidateModeldata.isStatus());
			candidate.setPersonalEmail(candidateModeldata.getPersonalEmail());
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			Date startDate = df.parse(actionRequest.getParameter("dateOfBirth"));
			candidate.setDateOfBirth(startDate);
			
			Date date = new Date();
		    System.out.println(date);
		    	candidate.setModifiedDate(date);
		 
		 ServiceContext serviceContext = null;
		serviceContext = ServiceContextFactory.getInstance(
						Candidate.class.getName(), actionRequest);

		candidate.setModifiedBy(serviceContext.getUserId());
			
			System.out.println(candidate);
		CandidateLocalServiceUtil.updateCandidate(candidate);
	
			
			
		      
           
		}
		else
		{
			candidateId = CounterLocalServiceUtil.increment(Candidate.class.getName());
			
			Candidate candidate = CandidateLocalServiceUtil.createCandidate(candidateId);
			candidate.setEmployeeDepartmentId(candidateModeldata.getEmployeeDepartmentId());
			candidate.setEmployeeSubDepartmentId(candidateModeldata.getEmployeeSubDepartmentId());
			candidate.setEmployeeDesignationId(candidateModeldata.getEmployeeDesignationId());
			candidate.setTitle(candidateModeldata.getTitle());
			candidate.setFirstName(candidateModeldata.getFirstName());System.out.println(candidateModeldata.getFirstName()+" fname");
			candidate.setMiddleName(candidateModeldata.getMiddleName());
			candidate.setLastName(candidateModeldata.getLastName());
			candidate.setGender(candidateModeldata.getGender());
			candidate.setNationality(candidateModeldata.getNationality());
			candidate.setCity(candidateModeldata.getCity());
			candidate.setCountryId(candidateModeldata.getCountryId());
			candidate.setStreet1(candidateModeldata.getStreet1());
			candidate.setStreet2(candidateModeldata.getStreet2());
			candidate.setStreet3(candidateModeldata.getStreet3());
			candidate.setEmployeeProofId(candidateModeldata.getEmployeeProofId());
			candidate.setCurrentCtc(candidateModeldata.getCurrentCtc());
			candidate.setShortListed(candidateModeldata.isShortListed());
			candidate.setStatus(candidateModeldata.isStatus());
			candidate.setPersonalEmail(candidateModeldata.getPersonalEmail());
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			Date startDate = df.parse(actionRequest.getParameter("dateOfBirth"));
			candidate.setDateOfBirth(startDate);
			
			Date date = new Date();
		    System.out.println(date);
		    	candidate.setCreateDate(date);
		 
		 ServiceContext serviceContext = null;
		serviceContext = ServiceContextFactory.getInstance(
						Candidate.class.getName(), actionRequest);

		candidate.setCreateBy(serviceContext.getUserId());
			
			System.out.println(candidate);
		CandidateLocalServiceUtil.addCandidate(candidate);
   
		}
	}
	@RenderMapping(params = "render=editCandidateDisplay")
	public ModelAndView editCandidate(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortalException,
			SystemException {
		ModelAndView modelAndView = new ModelAndView("createcandidate");
		try
		{
		long candidateId = ParamUtil.getLong(renderRequest, "candidateId");
		Candidate candidate = CandidateLocalServiceUtil.getCandidate(candidateId);
			System.out.println(candidate);
			modelAndView.addObject("candidate", candidate);
		}
		catch(Exception e)
		{}
		return modelAndView;
	}
	@RenderMapping(params = "render=viewCandidate")
	public ModelAndView viewCandidate(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortalException,
			SystemException {
		ModelAndView modelAndView = new ModelAndView("viewCandidate");
		try
		{
		long candidateId = ParamUtil.getLong(renderRequest, "candidateId");
		Candidate candidate = CandidateLocalServiceUtil.getCandidate(candidateId);
		System.out.println(candidate);
		modelAndView.addObject("candidate", candidate);
		}
		catch(Exception e)
		{}
		return modelAndView;
	}
	@ActionMapping(params = "action=deleteCandidate")
	public void deleteCandidate(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		try
		{
		long candidateId= ParamUtil.getLong(actionRequest, "candidateId");
		System.out.println(candidateId);
		CandidateLocalServiceUtil.deleteCandidate(candidateId);
		System.out.println("deleted");
		SessionMessages.add(actionRequest.getPortletSession(),"candidate-delete-success");
		LOG.info("Delete");
		}
		catch(Exception e)
		{
			SessionErrors.add(actionRequest.getPortletSession(),
					"candidate-delete-error");
			e.printStackTrace();
		}
	}
}

