package com.enation.javashop.core.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enation.eop.sdk.database.BaseSupport;
import com.enation.javashop.core.model.Userdy;
import com.enation.javashop.core.service.IUserDyManager;

public class UserDyManager extends BaseSupport<Userdy> implements
		IUserDyManager {

	// lzc 2015年1月6日10:44:04
	@Override
	public void add(Map map) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("userdy", map);
	}

	@Override
	public int get(String name, int type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Userdy> list(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Userdy> list(String userid, Date time, int islatest, int limit) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select * from userdy where user_id = ? and user_judgetime");
		switch (islatest) {
		case 1:
			sql.append("< ? order by user_judgetime desc ");
			break;
		default:
			sql.append("> ? order by user_judgetime ");
			break;
		}
		sql.append(" limit 0," + limit);
		return this.baseDaoSupport.queryForList(sql.toString(), Userdy.class,
				userid, time);
	}

}
