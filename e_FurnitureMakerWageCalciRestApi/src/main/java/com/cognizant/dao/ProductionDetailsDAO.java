package com.cognizant.dao;

import com.cognizant.model.ProductionDetails;
import com.cognizant.model.ProductionSummary;

public interface ProductionDetailsDAO {

	public int addProductionDetails(ProductionDetails productionDetail);
	public int modifyProductionDetails(ProductionDetails productionDetail,String recordId);
	public ProductionSummary getProductionSummary(String employeeCode,String furnitureCode,String updationStatus);
	public boolean updateWageStatus(String employeeCode,String furnitureCode,String newStatus);
}
