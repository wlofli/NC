package com.enation.javashop.core.service.impl;

import java.util.List;
import java.util.Map;

import com.enation.eop.sdk.database.BaseSupport;

import com.enation.javashop.core.model.Duser;
import com.enation.javashop.core.service.IDuserManager;

public class DuserManager extends BaseSupport<Duser> implements IDuserManager {

	@Override
	public void add(Duser duser) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("user", duser);
	}

	@Override
	public void save(Duser duser) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.update("user", duser,
				"userid=" + duser.getUser_id());
	}

	@Override
	public void save(Map value, String userid) {
		// TODO Auto-generated method stub
		try {
			this.baseDaoSupport.update("user", value, "userid=" + userid);
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	@Override
	public Duser get(String id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject(
				"select * from user where user_id = ?", Duser.class, id);
	}

	@Override
	public Duser get(String id, String username, int sex, String addr,
			String avtar) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport
				.queryForObject(
						"select * from user where user_weibo  = ? and user_name = ? and user_sex = ? and user_addr = ?",
						Duser.class, id, username, sex, addr);
	}

	@Override
	public boolean exist(String id) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select count(0) from user where user_weibo = ?");
		// switch (type) {
		// case 1:
		// sql.append("user_imei = ?");
		// break;
		// //undone;
		// default:
		// sql.append("user_weibo = ?");
		// break;
		// }
		if (this.baseDaoSupport.queryForInt(sql.toString(), id) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Duser> list() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from user",
				Duser.class);
	}

}
