package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cognizant.model.ProductionDetails;
import com.cognizant.model.ProductionSummary;


public class ProductionDetailsDAOImpl implements ProductionDetailsDAO{

	JdbcTemplate jdbcTemplate;
	public ProductionDetailsDAOImpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addProductionDetails(ProductionDetails productionDetail) {
		// TODO Auto-generated method stub
		String sql = "insert into ProductionDetails values(?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, productionDetail.getRecordId(),utilToSqlDateConverter(productionDetail.getWorkedOn()),productionDetail.getEmployeeCode(),productionDetail.getOrderId(),productionDetail.getFurnitureId(),productionDetail.getIntenseEffortAHrs(),productionDetail.getIntenseEffortBHrs(),productionDetail.getIntenseEffortCHrs(),productionDetail.getJobStatus(),productionDetail.getWageUpdationStatus());
	}


	
	@Override
	public int modifyProductionDetails(ProductionDetails productionDetail, String recordId) {
		// TODO Auto-generated method stub
		String sql = "update ProductionDetails set WorkedOn = ?,EmployeeCode = ?,OrderId=?,FurnitureId = ?,IntenseEffortAHrs = ?,IntenseEffortBHrs = ?,IntenseEffortCHrs = ?,JobStatus = ?,WageUpdationStatus = ? where RecordId = ? ";
		return jdbcTemplate.update(sql, productionDetail.getWorkedOn(),productionDetail.getEmployeeCode(),productionDetail.getOrderId(),productionDetail.getFurnitureId(),productionDetail.getIntenseEffortAHrs(),productionDetail.getIntenseEffortBHrs(),productionDetail.getIntenseEffortCHrs(),productionDetail.getJobStatus(),productionDetail.getWageUpdationStatus(),recordId);
	}

	@Override
	public ProductionSummary getProductionSummary(String empCode,String furnCode,String updationStatus){
		// TODO Auto-generated method stub
		String sql = "select sum(IntenseEffortAHrs),sum(IntenseEffortBHrs),sum(IntenseEffortCHrs) from ProductionDetails where employeeCode = '"+empCode+"' and FurnitureId = '"+furnCode+"' and WageUpdationStatus='"+updationStatus+"'"; 
		ResultSetExtractor <ProductionSummary> extractor = new ResultSetExtractor<ProductionSummary>() {

			@Override
			public ProductionSummary extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next())
				{
					int aTotHrs = rs.getInt(1);
					int bTotHrs = rs.getInt(2);
					int cTotHrs = rs.getInt(3);
					Date d1 = new Date();
					return new ProductionSummary(d1,empCode,furnCode,aTotHrs,bTotHrs,cTotHrs);
				}
				return null;
			}
			
			
		};
		
		
		return jdbcTemplate.query(sql, extractor);
	}
	
	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		java.sql.Date sqlDate = null;
		if (utDate != null) {
			sqlDate = new java.sql.Date(utDate.getTime());
		}
		return sqlDate;
	}
	
	public static java.util.Date stringToDateConverter(String stringDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(stringDate);
		} catch (ParseException pe) {
			return null;
		}
	}

	@Override
	public boolean updateWageStatus(String employeeCode, String furnitureCode,String newStatus) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update ProductionDetails set WageUpdationStatus = '"+newStatus+"' where employeeCode = '"+employeeCode+"' and FurnitureId = '"+furnitureCode+"' ";
		flag = true;
		jdbcTemplate.update(sql);
		return flag;
	}

}
