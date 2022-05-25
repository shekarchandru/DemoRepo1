package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ProductionDetailsDAO;
import com.cognizant.dao.ProductionDetailsDAOImpl;
import com.cognizant.model.ProductionDetails;
import com.cognizant.model.ProductionSummary;

@Service
public class ProductionDetailsService {
	
	@Autowired
	private DataSourceService dataService;
	
	DriverManagerDataSource dataSource;
	ProductionDetailsDAO productionDao;

	public int addProductionDetailsSvc(ProductionDetails productionDetail)
	{
		dataSource = dataService.getDataSource();
		productionDao = new ProductionDetailsDAOImpl(dataSource);
		return productionDao.addProductionDetails(productionDetail);
	}
	public int modifyProductionDetailsSvc(ProductionDetails productionDetail,String recordId)
	{
		dataSource = dataService.getDataSource();
		productionDao = new ProductionDetailsDAOImpl(dataSource);
		return productionDao.modifyProductionDetails(productionDetail, recordId);
	}
	public ProductionSummary getProductionSummarySvc(String employeeCode,String furnitureCode)
	{
		dataSource = dataService.getDataSource();
		productionDao = new ProductionDetailsDAOImpl(dataSource);
		return productionDao.getProductionSummary(employeeCode, furnitureCode, "NotUpdated");
	}
}
