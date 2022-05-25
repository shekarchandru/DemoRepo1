package com.cognizant.model;

public class Registration {

	String loginId;
	String password;
	String personName;
	String role;
	
	
	public Registration() {
		super();
	}


	public Registration(String loginId, String password, String personName, String role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.personName = personName;
		this.role = role;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Registration [loginId=" + loginId + ", password=" + password + ", personName=" + personName + ", role="
				+ role + "]";
	}
	
	
	
}
