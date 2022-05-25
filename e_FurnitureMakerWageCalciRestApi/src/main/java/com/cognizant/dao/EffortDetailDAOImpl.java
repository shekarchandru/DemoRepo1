package com.cognizant.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cognizant.model.EffortDetails;

public class EffortDetailDAOImpl implements EffortDetailDAO{

	JdbcTemplate jdbcTemplate;
	public EffortDetailDAOImpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public int addEffortDetail(EffortDetails effortDetail) {
		// TODO Auto-generated method stub
		String sql = "insert into EffortDetails values(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, effortDetail.getEffortId(),effortDetail.getFurnitureId(),effortDetail.getFurnitureName(),effortDetail.getQualityType(),effortDetail.getIntenseEffortAHrs(),effortDetail.getIntenseEffortBHrs(),effortDetail.getIntenseEffortCHrs());
	}

	@Override
	public int modifyEffortDetail(EffortDetails effortDetail, String effortId) {
		// TODO Auto-generated method stub
		String sql = "update EffortDetails set FurnitureId = ?, FurnitureName = ? , QualityType = ? , IntenseEffortAHrs = ? , IntenseEffortBHrs = ? , IntenseEffortCHrs = ? where EffortId = ? ";
		return jdbcTemplate.update(sql, effortDetail.getFurnitureId(),effortDetail.getFurnitureName(),effortDetail.getQualityType(),effortDetail.getIntenseEffortAHrs(),effortDetail.getIntenseEffortBHrs(),effortDetail.getIntenseEffortCHrs(),effortId);
	}

}
