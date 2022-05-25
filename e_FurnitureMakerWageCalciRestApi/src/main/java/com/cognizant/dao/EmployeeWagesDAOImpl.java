package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.cognizant.model.EmployeeWages;

public class EmployeeWagesDAOImpl implements EmployeeWagesDAO {

	JdbcTemplate jdbcTemplate;
	
	public EmployeeWagesDAOImpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List <EmployeeWages> getEmployeeWages(String employeeCode, String furnitureId) {
		// TODO Auto-generated method stub
		String sql = "select * from EmployeeWages where employeeCode = '"+employeeCode+"' and furnitureCode = '"+furnitureId+"' ";

		RowMapper <EmployeeWages> rowMapper = new RowMapper<EmployeeWages>() {

			@Override
			public EmployeeWages mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				int wageId = rs.getInt(1);
				Date dataOfUpdation = rs.getDate(2);
				String empCode = rs.getString(3);
				String furnitureCode = rs.getString(4);
				int totEffortAhrs = rs.getInt(5);
				int totEffortBhrs = rs.getInt(6);
				int totEffortChrs = rs.getInt(7);
				double totalWage = rs.getDouble(8);
				return new EmployeeWages(wageId,dataOfUpdation,empCode,furnitureCode,totEffortAhrs,totEffortBhrs,totEffortChrs,totalWage);
				
			}
			
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}
	/* TO GENERATE EMPLOYEE WAGES DETAILS 
	 * STEP 01
	 *----- select sum(IntenseEffortAHrs),sum(IntenseEffortBHrs),sum(IntenseEffortCHrs)
	------from ProductionDetails 
	------where employeeCode = 'Emp1' and FurnitureId = 'F001' and WageUpdationStatus='NotUpdated'; 
	
	IT IS ASSUMED THAT the SUm total for each category of effort like A/B/C 
	matches with the effortDetail - may be some triggers could be running
	that feature is not within the scope of this API
	Now Based on the WAGE MASTER for the respective effort 
	calculate the total wage and then Update the Table EmployeeWages
	
	And subsequently update the ProductionDetails table 's column WageUpdationStatus to
	'Updated' 
	meaning pick only those records with this status which is 'NotUpdated' for wage calculation
	 */
	
	@Override
	public int generateNInsertWageDetails(EmployeeWages employeeWages) {
		// TODO Auto-generated method stub
		String sql = "insert into EmployeeWages values(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, employeeWages.getWageId(),utilToSqlDateConverter(employeeWages.getDateOfUpdation()),employeeWages.getEmployeeCode(),employeeWages.getFurnitureCode(),employeeWages.getTotalEffortAhrs(),employeeWages.getTotalEffortBhrs(),employeeWages.getTotalEffortChrs(),employeeWages.getTotalWageInRs());
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
	public int modifyEmployeeWageDetails(EmployeeWages employeeWages, int wageId) {
		// TODO Auto-generated method stub
		String sql = "update EmployeeWages set DateOfUpdation = ?,EmployeeCode = ?,FurnitureCode=?,TotalEffortAhrs=?,TotalEffortBhrs=?,TotalEffortChrs = ?,totalWageInRs = ? where wageId = ?";
		
		return jdbcTemplate.update(sql, utilToSqlDateConverter(employeeWages.getDateOfUpdation()),employeeWages.getEmployeeCode(),employeeWages.getFurnitureCode(),employeeWages.getTotalEffortAhrs(),employeeWages.getTotalEffortBhrs(),employeeWages.getTotalEffortChrs(),employeeWages.getTotalWageInRs(),wageId);
	}

}
