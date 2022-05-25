package com.cognizant.model;

import java.util.Date;

public class EmployeeWages {


		int wageId;
		Date dateOfUpdation;
		String employeeCode;
		String furnitureCode;
		int totalEffortAhrs; /* On the date of Updation */
		int totalEffortBhrs; /* calculate the total effort put by employee in each category A/B/C */
		int totalEffortChrs; /* On particular furniture*/
		double totalWageInRs;
		
		
		public EmployeeWages() {
			super();
		}


		public EmployeeWages(int wageId, Date dateOfUpdation, String employeeCode, String furnitureCode,
				int totalEffortAhrs, int totalEffortBhrs, int totalEffortChrs, double totalWageInRs) {
			super();
			this.wageId = wageId;
			this.dateOfUpdation = dateOfUpdation;
			this.employeeCode = employeeCode;
			this.furnitureCode = furnitureCode;
			this.totalEffortAhrs = totalEffortAhrs;
			this.totalEffortBhrs = totalEffortBhrs;
			this.totalEffortChrs = totalEffortChrs;
			this.totalWageInRs = totalWageInRs;
		}


		public int getWageId() {
			return wageId;
		}


		public void setWageId(int wageId) {
			this.wageId = wageId;
		}


		public Date getDateOfUpdation() {
			return dateOfUpdation;
		}


		public void setDateOfUpdation(Date dateOfUpdation) {
			this.dateOfUpdation = dateOfUpdation;
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


		public int getTotalEffortAhrs() {
			return totalEffortAhrs;
		}


		public void setTotalEffortAhrs(int totalEffortAhrs) {
			this.totalEffortAhrs = totalEffortAhrs;
		}


		public int getTotalEffortBhrs() {
			return totalEffortBhrs;
		}


		public void setTotalEffortBhrs(int totalEffortBhrs) {
			this.totalEffortBhrs = totalEffortBhrs;
		}


		public int getTotalEffortChrs() {
			return totalEffortChrs;
		}


		public void setTotalEffortChrs(int totalEffortChrs) {
			this.totalEffortChrs = totalEffortChrs;
		}


		public double getTotalWageInRs() {
			return totalWageInRs;
		}


		public void setTotalWageInRs(double totalWageInRs) {
			this.totalWageInRs = totalWageInRs;
		}


		@Override
		public String toString() {
			return "EmployeeWages [wageId=" + wageId + ", dateOfUpdation=" + dateOfUpdation + ", employeeCode="
					+ employeeCode + ", furnitureCode=" + furnitureCode + ", totalEffortAhrs=" + totalEffortAhrs
					+ ", totalEffortBhrs=" + totalEffortBhrs + ", totalEffortChrs=" + totalEffortChrs
					+ ", totalWageInRs=" + totalWageInRs + "]";
		}
		
		
		
	
}
