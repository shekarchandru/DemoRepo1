package com.cognizant.model;

public class WageMaster {

	String wageId;
	String effortType; /* intenseEffortA/B/C*/
	double costPerHrRs;
	
	public WageMaster() {
		super();
	}

	public WageMaster(String wageId, String effortType, double costPerHrRs) {
		super();
		this.wageId = wageId;
		this.effortType = effortType;
		this.costPerHrRs = costPerHrRs;
	}

	public String getWageId() {
		return wageId;
	}

	public void setWageId(String wageId) {
		this.wageId = wageId;
	}

	public String getEffortType() {
		return effortType;
	}

	public void setEffortType(String effortType) {
		this.effortType = effortType;
	}

	public double getCostPerHrRs() {
		return costPerHrRs;
	}

	public void setCostPerHrRs(double costPerHrRs) {
		this.costPerHrRs = costPerHrRs;
	}

	@Override
	public String toString() {
		return "WageMaster [wageId=" + wageId + ", effortType=" + effortType + ", costPerHrRs=" + costPerHrRs + "]";
	}
	 
	
	
}
