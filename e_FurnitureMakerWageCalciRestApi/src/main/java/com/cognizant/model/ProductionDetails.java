package com.cognizant.model;

import java.util.Date;

public class ProductionDetails {

	

	String recordId;
	Date workedOn;
	String employeeCode;
	String orderId;
	String furnitureId;
	int intenseEffortAHrs; /* Amount of hours of effort put in each category  */
	int intenseEffortBHrs;
	int intenseEffortCHrs;
	String jobStatus; /* InProgress/Completed */
	String wageUpdationStatus;  /*Updated/NotUpdated in EmployeeWages Table or Not */
	
	
	public ProductionDetails() {
		super();
	}


	


	public ProductionDetails(String recordId, Date workedOn, String employeeCode, String orderId, String furnitureId,
			int intenseEffortAHrs, int intenseEffortBHrs, int intenseEffortCHrs, String jobStatus,
			String wageUpdationStatus) {
		super();
		this.recordId = recordId;
		this.workedOn = workedOn;
		this.employeeCode = employeeCode;
		this.orderId = orderId;
		this.furnitureId = furnitureId;
		this.intenseEffortAHrs = intenseEffortAHrs;
		this.intenseEffortBHrs = intenseEffortBHrs;
		this.intenseEffortCHrs = intenseEffortCHrs;
		this.jobStatus = jobStatus;
		this.wageUpdationStatus = wageUpdationStatus;
	}





	public String getRecordId() {
		return recordId;
	}


	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}


	public Date getWorkedOn() {
		return workedOn;
	}


	public void setWorkedOn(Date workedOn) {
		this.workedOn = workedOn;
	}


	public String getEmployeeCode() {
		return employeeCode;
	}


	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}


	public String getFurnitureId() {
		return furnitureId;
	}


	public void setFurnitureId(String furnitureId) {
		this.furnitureId = furnitureId;
	}


	public int getIntenseEffortAHrs() {
		return intenseEffortAHrs;
	}


	public void setIntenseEffortAHrs(int intenseEffortAHrs) {
		this.intenseEffortAHrs = intenseEffortAHrs;
	}


	public int getIntenseEffortBHrs() {
		return intenseEffortBHrs;
	}


	public void setIntenseEffortBHrs(int intenseEffortBHrs) {
		this.intenseEffortBHrs = intenseEffortBHrs;
	}


	public int getIntenseEffortCHrs() {
		return intenseEffortCHrs;
	}


	public void setIntenseEffortCHrs(int intenseEffortCHrs) {
		this.intenseEffortCHrs = intenseEffortCHrs;
	}


	public String getJobStatus() {
		return jobStatus;
	}


	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}


	public String getWageUpdationStatus() {
		return wageUpdationStatus;
	}


	public void setWageUpdationStatus(String wageUpdationStatus) {
		this.wageUpdationStatus = wageUpdationStatus;
	}


	
	public String getOrderId() {
		return orderId;
	}





	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}





	@Override
	public String toString() {
		return "ProductionDetails [recordId=" + recordId + ", workedOn=" + workedOn + ", employeeCode=" + employeeCode
				+ ", orderId=" + orderId + ", furnitureId=" + furnitureId + ", intenseEffortAHrs=" + intenseEffortAHrs
				+ ", intenseEffortBHrs=" + intenseEffortBHrs + ", intenseEffortCHrs=" + intenseEffortCHrs
				+ ", jobStatus=" + jobStatus + ", wageUpdationStatus=" + wageUpdationStatus + "]";
	}





	
	
	
	
	 
}
