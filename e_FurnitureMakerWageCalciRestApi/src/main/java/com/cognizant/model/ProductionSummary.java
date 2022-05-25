package com.cognizant.model;

import java.util.Date;

public class ProductionSummary {

	Date updateDate;
	String employeeCode;
	String furnitureCode;
	int totalIntenseAHrsTillDate;
	int totalIntenseBHrsTillDate;
	int totalIntenseCHrsTillDate;
	
	public ProductionSummary() {
		super();
	}

	public ProductionSummary(Date updateDate, String employeeCode, String furnitureCode, int totalIntenseAHrsTillDate,
			int totalIntenseBHrsTillDate, int totalIntenseCHrsTillDate) {
		super();
		this.updateDate = updateDate;
		this.employeeCode = employeeCode;
		this.furnitureCode = furnitureCode;
		this.totalIntenseAHrsTillDate = totalIntenseAHrsTillDate;
		this.totalIntenseBHrsTillDate = totalIntenseBHrsTillDate;
		this.totalIntenseCHrsTillDate = totalIntenseCHrsTillDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getFurnitureCode() {
		return furnitureCode;
	}

	public void setFurnitureCode(String furnitureCode) {
		this.furnitureCode = furnitureCode;
	}

	public int getTotalIntenseAHrsTillDate() {
		return totalIntenseAHrsTillDate;
	}

	public void setTotalIntenseAHrsTillDate(int totalIntenseAHrsTillDate) {
		this.totalIntenseAHrsTillDate = totalIntenseAHrsTillDate;
	}

	public int getTotalIntenseBHrsTillDate() {
		return totalIntenseBHrsTillDate;
	}

	public void setTotalIntenseBHrsTillDate(int totalIntenseBHrsTillDate) {
		this.totalIntenseBHrsTillDate = totalIntenseBHrsTillDate;
	}

	public int getTotalIntenseCHrsTillDate() {
		return totalIntenseCHrsTillDate;
	}

	public void setTotalIntenseCHrsTillDate(int totalIntenseCHrsTillDate) {
		this.totalIntenseCHrsTillDate = totalIntenseCHrsTillDate;
	}

	@Override
	public String toString() {
		return "ProductionSummary [updateDate=" + updateDate + ", employeeCode=" + employeeCode + ", furnitureCode="
				+ furnitureCode + ", totalIntenseAHrsTillDate=" + totalIntenseAHrsTillDate
				+ ", totalIntenseBHrsTillDate=" + totalIntenseBHrsTillDate + ", totalIntenseCHrsTillDate="
				+ totalIntenseCHrsTillDate + "]";
	}
	
	
	
}
