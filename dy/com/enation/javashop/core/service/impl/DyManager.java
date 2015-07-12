package com.enation.javashop.core.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enation.eop.sdk.database.BaseSupport;
import com.enation.javashop.core.model.Duser;
import com.enation.javashop.core.model.Dy;
import com.enation.javashop.core.model.mapper.DyMapper;
import com.enation.javashop.core.service.IDyManager;

public class DyManager extends BaseSupport<Dy> implements IDyManager {

	private int type;

	@Override
	public void add(Dy dy) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("dy", dy);
	}

	@Override
	public void setResult(Map map, String id) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.update("dy", map, id);

	}

	@Override
	public void setResult(String dyid, int state) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("dy_state", state);
		this.baseDaoSupport.update("dy", map, "dyid=" + dyid);

	}

	// 根据userid获取Dy列表
	public List<Dy> list(String userid) {
		// 访问sql，调用Dy类，以List方式返回，得到userid
		String sql = "select * from dy where user_id = ?";
		return this.baseDaoSupport.queryForList(sql, Dy.class, userid);
	}

	@Override
	public List<Dy> list(int type, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select * from dy ");
		switch (type) {
		case 1:
			sql.append("order by dy_look");
			break;
		case 2:
			sql.append("order by dy_createtime");
			break;
		case 3:
			sql.append("order by dy_choose");
			break;
		case 4:
			sql.append("where dy_picture = 0");
			break;
		default:
			break;
		}
		return this.baseDaoSupport.queryForList(sql.toString(), pageNo,
				pageSize, new DyMapper());
	}

	@Override
	public void get(String content, int type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatedy(Integer choosey, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Integer choose, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void get(Date finaltime) {
		// TODO Auto-generated method stub

	}

	@Override
	public int get(Integer state) {
		return state;
		// TODO Auto-generated method stub

	}

	@Override
	public Dy get(String dyid) {// lzc
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject(
				"select * from dy where dy_id = ?", Dy.class, dyid);
	}

}
