package com.enation.core.service.impl;

import java.util.List;

import com.enation.core.model.Indiv;
import com.enation.core.service.IIndivManager;
import com.enation.eop.sdk.database.BaseSupport;

public class IndivManager extends BaseSupport<Indiv> implements IIndivManager{

	@Override
	public void add(Indiv indiv) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("indiv", indiv);
	}

	@Override
	public List<Indiv> list(String id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from indiv where anaid = ? ", Indiv.class, id);
	}

}
