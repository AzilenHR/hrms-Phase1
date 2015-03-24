package com.hrms;

public class LeaveModel{
private String leaveName;
private String leaveType;
private int leavesAllowedPerYear;
private boolean carryOver;
private int carryOverLimit;
private boolean encachement;
private String Status;
public String getLeaveName() {
	return leaveName;
}
public void setLeaveName(String leaveName) {
	this.leaveName = leaveName;
}
public String getLeaveType() {
	return leaveType;
}
public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
}
public int getLeavesAllowedPerYear() {
	return leavesAllowedPerYear;
}
public void setLeavesAllowedPerYear(int leavesAllowedPerYear) {
	this.leavesAllowedPerYear = leavesAllowedPerYear;
}
public boolean isCarryOver() {
	return carryOver;
}
public void setCarryOver(boolean carryOver) {
	this.carryOver = carryOver;
}
public boolean getCarryOver(){
	return carryOver;
}
public boolean isEncachement() {
	return encachement;
}
public void setEncachement(boolean encachement) {
	this.encachement = encachement;
}
public boolean getEncachement(){
	return carryOver;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public void setCarryOverLimit(int carryOverLimit){
	this.carryOverLimit=carryOverLimit;
}
public int getCarryOverLimit(){
	return carryOverLimit;
	
}
	
}
