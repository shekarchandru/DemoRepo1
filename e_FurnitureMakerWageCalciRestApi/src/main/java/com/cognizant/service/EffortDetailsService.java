package com.cognizant.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EffortDetailDAO;
import com.cognizant.dao.EffortDetailDAOImpl;
import com.cognizant.exception.BusinessException;
import com.cognizant.model.EffortDetails;

@Service
public class EffortDetailsService {

	@Autowired
	private DataSourceService dataService;
	
	DriverManagerDataSource dataSource;
	EffortDetailDAO effortDetailDao;
	
	public int addEffortDetailSvc(EffortDetails effortDetail)
	{
		dataSource = dataService.getDataSource();
	
			if(effortDetail.getFurnitureId().isEmpty() || effortDetail.getFurnitureId().length() ==  0)
			{
				throw new BusinessException("601","Sorry,EffortDetail Id Can't be Blank");
			}
		try
		{
			effortDetailDao = new EffortDetailDAOImpl(dataSource);
			return effortDetailDao.addEffortDetail(effortDetail);
		}
		catch(IllegalArgumentException ie)
		{
			throw new BusinessException("602","You Have Not Passed Effort Detail Object"+ie.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("603","Exception Occurred in the Effort Detail Service Layer while "+e.getMessage());
		}
		
	}
	public int modifyEffortDetailSvc(EffortDetails effortDetail,String effortId)
	{
		dataSource = dataService.getDataSource();
		effortDetailDao = new EffortDetailDAOImpl(dataSource);
		try
		{
			return effortDetailDao.modifyEffortDetail(effortDetail, effortId);
		}
		catch(IllegalArgumentException ie)
		{
			throw new BusinessException("604","You Have Not Passed apt Arguments"+ie.getMessage());
		}
		catch(NoSuchElementException ne)
		{
			throw new BusinessException("605","Effort Id Does not Exist Please Check "+ne.getMessage());
		}
	}
}
