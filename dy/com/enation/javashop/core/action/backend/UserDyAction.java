package com.enation.javashop.core.action.backend;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.enation.framework.action.WWAction;
import com.enation.javashop.core.service.IUserDyManager;

public class UserDyAction extends WWAction {

	private String id;
	private String dyid;
	private int judge;
	private IUserDyManager userDyManager;

	/*
	 * lzc 2015年1月6日09:49:07 参与dy判断
	 */
	public String judgedy() {
		JSONObject json = new JSONObject();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user_id", id);
			map.put("dy_id", dyid);
			map.put("user_judge", judge);
			map.put("user_judgetime", new Timestamp(System.currentTimeMillis()));// 设置时间
			this.userDyManager.add(map);
			json.accumulate("suc", "0");
		} catch (Exception e) {
			// TODO: handle exception
			json.accumulate("suc", "2");
		}
		renderHtml(json.toString());
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDyid() {
		return dyid;
	}

	public void setDyid(String dyid) {
		this.dyid = dyid;
	}

	public int getJudge() {
		return judge;
	}

	public void setJudge(int judge) {
		this.judge = judge;
	}

	public IUserDyManager getUserDyManager() {
		return userDyManager;
	}

	public void setUserDyManager(IUserDyManager userDyManager) {
		this.userDyManager = userDyManager;
	}

}
