package com.enation.core.service.impl;

import java.util.List;

import com.enation.core.model.Industry;
import com.enation.core.service.IIndustryManager;
import com.enation.eop.sdk.database.BaseSupport;

public class IndustryManager extends BaseSupport<Industry> implements IIndustryManager{

	@Override
	public void add(Industry industry) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("industry", industry);
	}

	@Override
	public List<Industry> list(String id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from industry where anaid = ? ", Industry.class, id);
	}


}
