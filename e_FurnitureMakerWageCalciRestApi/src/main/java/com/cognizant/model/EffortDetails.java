package com.cognizant.model;

public class EffortDetails {


	String effortId;
	String furnitureId;
	String furnitureName;
	String qualityType;
	int intenseEffortAHrs;
	int intenseEffortBHrs;
	int intenseEffortCHrs;
	
	public EffortDetails() {
		super();
	}

	public EffortDetails(String effortId, String furnitureId, String furnitureName, String qualityType,
			int intenseEffortAHrs, int intenseEffortBHrs, int intenseEffortCHrs) {
		super();
		this.effortId = effortId;
		this.furnitureId = furnitureId;
		this.furnitureName = furnitureName;
		this.qualityType = qualityType;
		this.intenseEffortAHrs = intenseEffortAHrs;
		this.intenseEffortBHrs = intenseEffortBHrs;
		this.intenseEffortCHrs = intenseEffortCHrs;
	}

	public String getEffortId() {
		return effortId;
	}

	public void setEffortId(String effortId) {
		this.effortId = effortId;
	}

	public String getFurnitureId() {
		return furnitureId;
	}

	public void setFurnitureId(String furnitureId) {
		this.furnitureId = furnitureId;
	}

	public String getFurnitureName() {
		return furnitureName;
	}

	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}

	public String getQualityType() {
		return qualityType;
	}

	public void setQualityType(String qualityType) {
		this.qualityType = qualityType;
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

	@Override
	public String toString() {
		return "EffortDetails [effortId=" + effortId + ", furnitureId=" + furnitureId + ", furnitureName="
				+ furnitureName + ", qualityType=" + qualityType + ", intenseEffortAHrs=" + intenseEffortAHrs
				+ ", intenseEffortBHrs=" + intenseEffortBHrs + ", intenseEffortCHrs=" + intenseEffortCHrs + "]";
	}
	
	
	 
}
