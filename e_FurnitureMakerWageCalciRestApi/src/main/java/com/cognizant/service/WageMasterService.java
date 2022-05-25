package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.cognizant.dao.WageMasterDAO;
import com.cognizant.dao.WageMasterDAOImpl;
import com.cognizant.model.WageMaster;

@Service
public class WageMasterService {
	
	@Autowired
	private DataSourceService dataService;
	DriverManagerDataSource dataSource;
	WageMasterDAO wageMasterDao;

	public int addWageMasterSvc(WageMaster wageMaster)
	{
		dataSource = dataService.getDataSource();
		wageMasterDao = new WageMasterDAOImpl(dataSource);
		return wageMasterDao.addWageMaster(wageMaster);
	}
	public int deleteWageMasterSvc(String wageId)
	{
		dataSource = dataService.getDataSource();
		wageMasterDao = new WageMasterDAOImpl(dataSource);
		return wageMasterDao.deleteWageMaster(wageId);
	}
	public List <WageMaster> getWageMasterDetailsSvc()
	{
		dataSource = dataService.getDataSource();
		wageMasterDao = new WageMasterDAOImpl(dataSource);
		return wageMasterDao.getWageMasterDetails();
	}
}
