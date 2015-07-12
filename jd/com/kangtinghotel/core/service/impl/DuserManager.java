package com.kangtinghotel.core.service.impl;

import java.util.Map;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Duser;
import com.kangtinghotel.core.service.IDuserManager;

public class DuserManager extends BaseSupport<Duser> implements IDuserManager{

	@Override
	public void add(Duser user) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("user", user);
	}

	@Override
	public boolean exist(String id) {
		// TODO Auto-generated method stub
		if(this.baseDaoSupport.queryForInt(" select count(id) from user where id = ? ", id) == 0){
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public boolean exist(String id, String password) {
		// TODO Auto-generated method stub
		if (this.baseDaoSupport.queryForInt(" select count(*) from user where id = ? and password = ? ", id, password) == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean login(String id, String password) {
		// TODO Auto-generated method stub
		if (this.baseDaoSupport.queryForInt(" select count(id) from user where id = ? and password = ?", id, password) == 0) {
			return false;
		} else {
			return true;
		}
	}
	

	@Override
	public void modify(String id, Map map) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.update("user", map, "id = " + id);
	}
	
	@Override
	public void modify(String id, String password) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.execute("update user set password = ? where id = ?", password, id);
	}

	@Override
	public Duser get(String id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject("select * from user where id = ?", Duser.class, id);
	}

	

	

}
