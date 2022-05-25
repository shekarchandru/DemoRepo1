package com.cognizant.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.EmployeeWages;

public interface EmployeeWagesDAO {

	public List <EmployeeWages> getEmployeeWages(String employeeCode,String furnitureId);
	public int generateNInsertWageDetails(EmployeeWages employeeWages);
	public int modifyEmployeeWageDetails(EmployeeWages employeeWages,int wageId);
}
