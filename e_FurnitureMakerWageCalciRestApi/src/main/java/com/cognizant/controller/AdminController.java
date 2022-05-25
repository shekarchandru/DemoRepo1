package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.BusinessException;
import com.cognizant.exception.ControllerException;
import com.cognizant.model.EffortDetails;
import com.cognizant.model.WageMaster;
import com.cognizant.service.EffortDetailsService;
import com.cognizant.service.WageMasterService;

@RestController
public class AdminController {
	
	@Autowired
	EffortDetailsService effortService;
	
	@Autowired
	WageMasterService wageService;
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Welcome to the eFurnitureMaker Wages Calci REST Api";
	}
	
	@PostMapping("/addEffortDetail")
	public ResponseEntity <?> addEffortDetail(@RequestBody EffortDetails effortDetail)
	{
		try
		{
			int rowsAffected =  effortService.addEffortDetailSvc(effortDetail);
			return new ResponseEntity <Object> (rowsAffected,HttpStatus.CREATED);
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
		}
		/*if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Effort Detail Inserted Successfully",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity <>("Effort Detail Insertion Failed",HttpStatus.BAD_REQUEST);
		}*/
		
		
	}
	
	@PutMapping("/modifyEffortDetail/{effortId}")
	public ResponseEntity <Object> modifyEffortDetail(@RequestBody EffortDetails effortDetail,@PathVariable String effortId)
	{
		int rowsAffected = effortService.modifyEffortDetailSvc(effortDetail, effortId);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Effort Detail  Updated Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity <>("Effort Detail   Not Found for the Id",HttpStatus.NOT_FOUND);
		}
		 
		
	}
	
	@PostMapping("/addWageMaster")
	public ResponseEntity <Object> addWageMaster(@RequestBody WageMaster wageMaster)
	{
		int rowsAffected =  wageService.addWageMasterSvc(wageMaster);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Wage Master Inserted Successfully",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity <>("Wage Master Insertion Failed",HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	@DeleteMapping("/deleteWageMaster/{wageId}")
	public ResponseEntity <Object> deleteWageMasterById(@PathVariable String wageId)
	{
		int rowsAffected = wageService.deleteWageMasterSvc(wageId);
		
		if( rowsAffected > 0)
		{
			return new ResponseEntity<>("Wage Master Detail Deleted Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity <>("Wage Master Detail Not Found for the Id",HttpStatus.NOT_FOUND);
		}
		 
	}
	

}
