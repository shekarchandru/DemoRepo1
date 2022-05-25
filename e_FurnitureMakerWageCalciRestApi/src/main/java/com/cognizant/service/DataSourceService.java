package com.cognizant.service;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;



@Service
public class DataSourceService {

public DriverManagerDataSource dataSource;
	
	
	public DriverManagerDataSource getDataSource()
	{
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eFurnitureWageCalciDB");
		dataSource.setUsername("root");
		dataSource.setPassword("MySQL_@123456");
		return dataSource;
	}
	
	
}
