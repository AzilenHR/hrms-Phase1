package com.hrms;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CandidateModel {

	private long candidateId;
	
	private long employeeDepartmentId;
	private long employeeSubDepartmentId;
	private long employeeDesignationId;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nationality;
	private String street1;
	private String street2;
	private String street3;
	private long countryId;
	private String city;
	private Date dateOfBirth;
	private long zip;
	private String personalEmail;
	private long currentCtc;
	private long expectedCtc;
	private String noticePeriod;
	private long resumeId;
	private String resumePath;
	private long employeeProofId;
	private String proofNumber;
	private boolean status;
	private boolean shortListed;
	private Date createDate;
	private Date modifiedDate;
	private long modifiedBy;
	private long CreateBy;
	
	
	
	public long getEmployeeSubDepartmentId() {
		return employeeSubDepartmentId;
	}
	public void setEmployeeSubDepartmentId(long employeeSubDepartmentId) {
		this.employeeSubDepartmentId = employeeSubDepartmentId;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public long getCurrentCtc() {
		return currentCtc;
	}
	public void setCurrentCtc(long currentCtc) {
		this.currentCtc = currentCtc;
	}
	public long getExpectedCtc() {
		return expectedCtc;
	}
	public void setExpectedCtc(long expectedCtc) {
		this.expectedCtc = expectedCtc;
	}
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public long getResumeId() {
		return resumeId;
	}
	public void setResumeId(long resumeId) {
		this.resumeId = resumeId;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	public long getEmployeeProofId() {
		return employeeProofId;
	}
	public void setEmployeeProofId(long employeeProofId) {
		this.employeeProofId = employeeProofId;
	}
	public String getProofNumber() {
		return proofNumber;
	}
	public void setProofNumber(String proofNumber) {
		this.proofNumber = proofNumber;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isShortListed() {
		return shortListed;
	}
	public void setShortListed(boolean shortListed) {
		this.shortListed = shortListed;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public long getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(long createBy) {
		CreateBy = createBy;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	private int gender;
	
public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getStreet3() {
		return street3;
	}
	public void setStreet3(String street3) {
		this.street3 = street3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public long getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}
	public void setEmployeeDepartmentId(long employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}
	public long getEmployeeDesignationId() {
		return employeeDesignationId;
	}
	public void setEmployeeDesignationId(long employeeDesignationId) {
		this.employeeDesignationId = employeeDesignationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	
}
