package com.cognizant.dao;

import com.cognizant.model.EffortDetails;

public interface EffortDetailDAO {

	public int addEffortDetail(EffortDetails effortDetail);
	public int modifyEffortDetail(EffortDetails effortDetail,String effortId);
}
