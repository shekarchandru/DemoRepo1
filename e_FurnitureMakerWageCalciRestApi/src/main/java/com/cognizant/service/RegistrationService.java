package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;


import com.cognizant.dao.RegistrationDAO;
import com.cognizant.dao.RegistrationDAOImpl;
import com.cognizant.model.Registration;

@Service
public class RegistrationService {

	
	@Autowired
	private DataSourceService dataService;
	
	public DriverManagerDataSource dataSource;
	public RegistrationDAO registrationDAO;
	
	public int registerCustomerSvc(Registration registration)
	{
		dataSource = dataService.getDataSource();
		registrationDAO = new RegistrationDAOImpl(dataSource);
		return registrationDAO.registerCustomer(registration);
	}
	
	public boolean authenticateCustomerSvc(Registration registration)
	{
		//Check if LoginController is needed
		dataSource = dataService.getDataSource();
		registrationDAO = new RegistrationDAOImpl(dataSource);
		return registrationDAO.checkLoginAvailability(registration);
	}
}
