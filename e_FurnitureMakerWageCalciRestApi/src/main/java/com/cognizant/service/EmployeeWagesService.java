package com.cognizant.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeWagesDAO;
import com.cognizant.dao.EmployeeWagesDAOImpl;
import com.cognizant.dao.ProductionDetailsDAO;
import com.cognizant.dao.ProductionDetailsDAOImpl;
import com.cognizant.exception.BusinessException;
import com.cognizant.model.EmployeeWages;
import com.cognizant.model.ProductionSummary;
import com.cognizant.model.WageMaster;

@Service
public class EmployeeWagesService {
	
	int count = 0;
	@Autowired
	private DataSourceService dataService;
	
	@Autowired
	private WageMasterService wageMasterService;
	
	@Autowired
	private EmployeeWagesService empWagesService;
	
	@Autowired
	private ProductionDetailsService productionService;
	
	DriverManagerDataSource dataSource;
	EmployeeWagesDAO empWagesDao;
	ProductionDetailsDAO productionDao;
	
	public List <EmployeeWages> getEmployeeWages(String employeeCode,String furnitureId)
	{
		dataSource = dataService.getDataSource();
		empWagesDao = new EmployeeWagesDAOImpl(dataSource);
		//Custom Exception s Implemented
		List <EmployeeWages> employeeWages = null;
		try
		{
			employeeWages = empWagesDao.getEmployeeWages(employeeCode, furnitureId);
		}
		catch(Exception e)
		{
			throw new BusinessException("607","Something Went wrong in the Employee Wages Service Layer...");
		}
		if(employeeWages.isEmpty())
		{
			throw new BusinessException("606","Sorry EmployeeWages Table is Empty...");
		}
		return employeeWages;
	}
	public int generateNInsertWageDetailsSvc(String employeeCode,String furnitureId)
	{
		ProductionSummary productionSummary = productionService.getProductionSummarySvc(employeeCode, furnitureId);
		//After getting the Current details for the employeecode and furniturecode
		//modify the WageUpdationSTatus in the ProductionDetails table to "Updated"
		//So that the records are not refetched for the wage calculation to 
		//avoid doubling
		dataSource = dataService.getDataSource();
		empWagesDao = new EmployeeWagesDAOImpl(dataSource);
		productionDao = new ProductionDetailsDAOImpl(dataSource);
		boolean updationResult = productionDao.updateWageStatus(employeeCode, furnitureId, "Updated");
		
		EmployeeWages empWages = getEmployeeWages(productionSummary);
		
		
		return empWagesDao.generateNInsertWageDetails(empWages);
	}
	public EmployeeWages getEmployeeWages(ProductionSummary productionSummary)
	{
		double costOfAPerHour = 0.0 ,costOfBPerHour = 0.0 ,costOfCPerHour = 0.0;
		List <WageMaster> wageMaster = wageMasterService.getWageMasterDetailsSvc();
		System.out.println("Wage Master "+wageMaster);
		double totalCost=0.0;
		
		Iterator <WageMaster> wageIter = wageMaster.iterator();
		while(wageIter.hasNext())
		{
			WageMaster wageMaster1 = wageIter.next();
			if(wageMaster1.getEffortType().equals("IntenseEffortAHrs"))
			{
				costOfAPerHour = wageMaster1.getCostPerHrRs();
				System.out.println(costOfAPerHour);
			}
			else if(wageMaster1.getEffortType().equals("IntenseEffortBHrs"))
			{
				costOfBPerHour = wageMaster1.getCostPerHrRs();
				System.out.println(costOfBPerHour);
			}
			else if(wageMaster1.getEffortType().equals("IntenseEffortCHrs"))
			{
				costOfCPerHour = wageMaster1.getCostPerHrRs();
				System.out.println(costOfCPerHour);
			}
			
		}
		System.out.println(productionSummary);
		totalCost = (productionSummary.getTotalIntenseAHrsTillDate() * costOfAPerHour) + (productionSummary.getTotalIntenseBHrsTillDate() * costOfBPerHour) +(productionSummary.getTotalIntenseCHrsTillDate() * costOfCPerHour);
		System.out.println("totalcost "+totalCost);
		count++;
		EmployeeWages empWages = new EmployeeWages(count,productionSummary.getUpdateDate(),productionSummary.getEmployeeCode(),productionSummary.getFurnitureCode(),productionSummary.getTotalIntenseAHrsTillDate(),productionSummary.getTotalIntenseBHrsTillDate(),productionSummary.getTotalIntenseCHrsTillDate(),totalCost);
		return empWages;
	}

	public int modifyEmployeeWageDetailsSvc(EmployeeWages employeeWages,int wageId)
	{
		dataSource = dataService.getDataSource();
		empWagesDao = new EmployeeWagesDAOImpl(dataSource);
		return empWagesDao.modifyEmployeeWageDetails(employeeWages, wageId);
		
	}
}
