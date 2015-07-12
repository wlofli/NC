package com.enation.core.service.impl;

import com.enation.core.model.Ana;
import com.enation.core.service.IAnaManager;
import com.enation.eop.sdk.database.BaseSupport;

public class AnaManager extends BaseSupport<Ana> implements IAnaManager{

	@Override
	public void add(Ana ana) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("ana", ana);
	}

	@Override
	public Ana get(int id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject("select * from ana where newsid = ? ", Ana.class, id);
	}

}
