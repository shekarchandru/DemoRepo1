package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.WageMaster;

public interface WageMasterDAO {

	public int addWageMaster(WageMaster wageMaster);
	public int deleteWageMaster(String wageId);
	public List <WageMaster> getWageMasterDetails();
}
