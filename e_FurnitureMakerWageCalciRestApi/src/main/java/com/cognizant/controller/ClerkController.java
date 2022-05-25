package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.EmployeeWages;
import com.cognizant.service.EmployeeWagesService;

@RestController
public class ClerkController {
	
	@Autowired
	private EmployeeWagesService empWageService;

	@PostMapping("/generateWageDetails/{employeeCode}/{furnitureId}")
	public ResponseEntity <?> generateNInsertWageDetails(@PathVariable String employeeCode,@PathVariable String furnitureId)
	{
		int rowsAffected =  empWageService.generateNInsertWageDetailsSvc(employeeCode, furnitureId);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Employee Wage Detail Generated & Inserted Successfully",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity <>("Employee Wage Detail Generation & Insertion Failed",HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	@PutMapping("/modifyEmployeeWageDetails/{wageId}")
	public ResponseEntity <Object> modifyEmployeeWageDetails(@RequestBody EmployeeWages employeeWages,@PathVariable int wageId)
	{
		int rowsAffected = empWageService.modifyEmployeeWageDetailsSvc(employeeWages, wageId);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Employee WageDetails Updated Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity <>("Employee Wage Details   Not Found for the Id",HttpStatus.NOT_FOUND);
		}
		 
	}
	
}
