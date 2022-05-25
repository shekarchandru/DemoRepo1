package com.cognizant.dao;

import com.cognizant.model.Registration;

public interface RegistrationDAO {

	public int registerCustomer(Registration registration);
	public boolean checkLoginAvailability(Registration registration);
}
