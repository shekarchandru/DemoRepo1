package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.BusinessException;
import com.cognizant.exception.ControllerException;
import com.cognizant.model.EmployeeWages;
import com.cognizant.model.ProductionDetails;
import com.cognizant.model.WageMaster;
import com.cognizant.service.EmployeeWagesService;
import com.cognizant.service.ProductionDetailsService;
import com.cognizant.service.WageMasterService;

@RestController
public class EmployeeController {
	
	@Autowired
	private ProductionDetailsService productionService;
	
	@Autowired
	private WageMasterService wageMasterService;
	
	@Autowired
	private EmployeeWagesService empWageService;

	@PostMapping("/addProductionDetails")
	public ResponseEntity <Object> addProductionDetails(@RequestBody ProductionDetails productionDetails)
	{
		 int rowsAffected =  productionService.addProductionDetailsSvc(productionDetails);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Production Details Inserted Successfully",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity <>("Production Details Insertion Failed",HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	@PutMapping("/modifyProductionDetail/{recordId}")
	public ResponseEntity <Object> modifyProductionDetails(@RequestBody ProductionDetails productionDetail,@PathVariable String recordId)
	{
		 int rowsAffected = productionService.modifyProductionDetailsSvc(productionDetail, recordId);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Production Detail  Updated Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity <>("Production Detail   Not Found for the Id",HttpStatus.NOT_FOUND);
		}
		 
	}
	
	@GetMapping("/viewWageDetails/{employeeCode}/{furnitureId}")
	public ResponseEntity <?>  getEmployeeWage(@PathVariable String employeeCode,@PathVariable String furnitureId)
	{
		try
		{
			List <EmployeeWages> empWages =  empWageService.getEmployeeWages(employeeCode, furnitureId);
			return new ResponseEntity <List <EmployeeWages>> (empWages,HttpStatus.CREATED);
		}
		catch(BusinessException be)
		{  // We can check the errorCode if it is 601,602 etc we can do accordingly
			ControllerException ce = new ControllerException(be.getErrorCode(),be.getErrorMessage());
			return new ResponseEntity <ControllerException> (ce, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce = new ControllerException("608","Something Went Wrong in Controller During Adding of EffortDetails");
			return new ResponseEntity <ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}/**/
		 
	//return empWageService.getEmployeeWages(employeeCode, furnitureId);
	}
	
	@GetMapping("/getWageMasterDetails")
	public List <WageMaster> getWageMasterDetails()
	{
		return wageMasterService.getWageMasterDetailsSvc();
	}
	
	
}
