package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.cognizant.model.Registration;
import com.cognizant.service.DataSourceService;

public class RegistrationDAOImpl implements RegistrationDAO{

	@Autowired
	private DataSourceService dataService;
	
	private JdbcTemplate jdbcTemplate;
	
	public RegistrationDAOImpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int registerCustomer(Registration registration) {
		// TODO Auto-generated method stub
		String sql = "insert into Registration values(?,?,?,?)";
		return jdbcTemplate.update(sql, registration.getLoginId(),registration.getPassword(),registration.getPersonName(),registration.getRole());
		
	}

	@Override
	public boolean checkLoginAvailability(Registration registration) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String cLoginId = registration.getLoginId();
		String cPassword = registration.getPassword();
		String cRole = registration.getRole();
		String sql = "select * from Registration where loginId = cLoginId and Password = cPassword and Role = cRole";
			
		ResultSetExtractor <Registration> extractor = new ResultSetExtractor<Registration>() {

			
				@Override
				public Registration extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					if(rs.next())
					{
						
						String loginId = rs.getString(1);
						String password = rs.getString(2);
						String role = rs.getString(4);
					
						
						return new Registration(loginId,password,registration.getPersonName(),role);
					}
					return null;
				}
				
			};
			
			// TODO Auto-generated method stub
			Registration actRegistration = jdbcTemplate.query(sql, extractor);
			if(registration.equals(actRegistration))
			{
				flag = true;
			}
			return flag;
	}

	
}
