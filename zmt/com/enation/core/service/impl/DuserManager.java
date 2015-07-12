package com.enation.core.service.impl;

import com.enation.core.model.Duser;
import com.enation.core.service.IDuserManager;
import com.enation.eop.sdk.database.BaseSupport;

public class DuserManager extends BaseSupport<Duser> implements IDuserManager{

	@Override
	public Duser login(String username) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject("select * from user where username = ?", Duser.class, username);
	}

}
