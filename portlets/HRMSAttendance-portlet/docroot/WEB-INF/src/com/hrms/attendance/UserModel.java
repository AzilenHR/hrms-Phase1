package com.hrms.attendance;

public class UserModel {

	private long userId;
	private String firstName;
	private String lastName;
	private String fullName;

	public UserModel(long userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return (this.firstName + " " + this.lastName);
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
