package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cognizant.model.WageMaster;

public class WageMasterDAOImpl implements WageMasterDAO{

	JdbcTemplate jdbcTemplate;
	public WageMasterDAOImpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public int addWageMaster(WageMaster wageMaster) {
		// TODO Auto-generated method stub
		String sql = "insert into WageMaster values(?,?,?)";
		return jdbcTemplate.update(sql, wageMaster.getWageId(),wageMaster.getEffortType(),wageMaster.getCostPerHrRs());
	}

	@Override
	public int deleteWageMaster(String wageId) {
		// TODO Auto-generated method stub
		String sql = "delete from WageMaster where wageId = ?";
		return jdbcTemplate.update(sql, wageId);
	}



	@Override
	public List<WageMaster> getWageMasterDetails() {
		// TODO Auto-generated method stub
		String sql = "select * from WageMaster";
		
		RowMapper <WageMaster> rowMapper = new RowMapper<WageMaster>() {

			@Override
			public WageMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				String wageId = rs.getString(1);
				String effortType = rs.getString(2);
				double costPerHr = rs.getDouble(3);
				return new WageMaster(wageId,effortType,costPerHr);
			}
			
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
