package com.hrms;

import java.util.Date;

public class LeaveApplyModel {
	String employeeName;
	String leaveName;
	String entitlement;
	String leaveDuration;
	Date leaveFrom;
	Date leaveTo;
	Date leaveDate;
	Date leavePeriod;
	String approvalStatus;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLeaveName() {
		return leaveName;
	}
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}
	public String getEntitlement() {
		return entitlement;
	}
	public void setEntitlement(String entitlement) {
		this.entitlement = entitlement;
	}
	public String getLeaveDuration() {
		return leaveDuration;
	}
	public void setLeaveDuration(String leaveDuration) {
		this.leaveDuration = leaveDuration;
	}
	public Date getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public Date getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Date getLeavePeriod() {
		return leavePeriod;
	}
	public void setLeavePeriod(Date leavePeriod) {
		this.leavePeriod = leavePeriod;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	

}
