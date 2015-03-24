package com.hrms.timesheet.model;

import java.io.File;

public class TimesheetModel {

	private String taskTitle, taskDate;
	private boolean billable;
	private String starttime, endtime, duration;
	private String taskDescription;
	private File taskFile;
	private boolean taskCompleted;

	public TimesheetModel() {
	}

	public TimesheetModel(String taskTitle, String taskDate, String starttime,
			String endtime, String duration) {
		super();
		this.taskTitle = taskTitle;
		this.taskDate = taskDate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.duration = duration;
	}

	public TimesheetModel(String taskTitle, String taskDate,
			boolean billable, String starttime, String endtime,
			String duration, String taskDescription, File taskFile,
			boolean taskCompleted) {
		super();
		this.taskTitle = taskTitle;
		this.taskDate = taskDate;
		this.billable = billable;
		this.starttime = starttime;
		this.endtime = endtime;
		this.duration = duration;
		this.taskDescription = taskDescription;
		this.taskFile = taskFile;
		this.taskCompleted = taskCompleted;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public boolean isBillable() {
		return billable;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public File getTaskFile() {
		return taskFile;
	}

	public void setTaskFile(File taskFile) {
		this.taskFile = taskFile;
	}

	public boolean isTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(boolean taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

}
