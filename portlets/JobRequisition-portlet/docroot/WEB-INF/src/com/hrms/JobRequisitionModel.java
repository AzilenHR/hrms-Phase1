package com.hrms;

import java.util.Date;

public class JobRequisitionModel {

	private long jobLibraryId;
	private String jobTitle;
	private String jobDescription;
	private String responsibility;
	private String qualifications;
	private String experience;
	private String benefits;
	private long salaryStartRange;
	private long employeeDepartmentId;
	private long salaryEndRange;
	private long reportsToId;
	private int numberOfPosition;
	private long createBy;
	private long modifiedBy;
	private Date createDate;
	private Date modifiedDate;
	public long getJobLibraryId() {
		return jobLibraryId;
	}
	public void setJobLibraryId(long jobLibraryId) {
		this.jobLibraryId = jobLibraryId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public long getSalaryStartRange() {
		return salaryStartRange;
	}
	public void setSalaryStartRange(long salaryStartRange) {
		this.salaryStartRange = salaryStartRange;
	}
	public long getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}
	public void setEmployeeDepartmentId(long employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}
	public long getSalaryEndRange() {
		return salaryEndRange;
	}
	public void setSalaryEndRange(long salaryEndRange) {
		this.salaryEndRange = salaryEndRange;
	}
	public long getReportsToId() {
		return reportsToId;
	}
	public void setReportsToId(long reportsToId) {
		this.reportsToId = reportsToId;
	}
	public int getNumberOfPosition() {
		return numberOfPosition;
	}
	public void setNumberOfPosition(int numberOfPosition) {
		this.numberOfPosition = numberOfPosition;
	}
	public long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
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
	
	
	}
