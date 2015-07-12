package com.kangtinghotel.core.action.backend;

import java.util.Map;

import net.sf.json.JSONObject;

import com.enation.framework.action.WWAction;
import com.enation.framework.util.RequestUtil;
import com.kangtinghotel.core.model.Duser;
import com.kangtinghotel.core.service.IDuserManager;
import com.kangtinghotel.core.util.MD5Util;

/*
 * lzc
 * 2015年1月23日10:50:05
 */

public class DuserAction extends WWAction{
	
	private IDuserManager duserManager;
	private String id;
	private String validCode;
	private String password;
	private String oldPassword;
	
	
	
	
	/*
	 * lzc
	 * 2015年1月27日13:43:45
	 */
	public void changePassword(){
		JSONObject jsonObject = new JSONObject();
		if (this.duserManager.exist(id, MD5Util.MD5(oldPassword))) {
			this.duserManager.modify(id, MD5Util.MD5(password));
			jsonObject.accumulate("suc", 0);
		}else {
			jsonObject.accumulate("exist", 0);
		}
		renderHtml(jsonObject.toString());
	}
	/*
	 * lzc
	 * 2015年1月26日10:57:30
	 */
	public void modify(){
		JSONObject jsonObject = new JSONObject();
		try {
			Map map = RequestUtil.paramToMap(this.getRequest());
			//假如参数有密码,MD5加密
			if(map.get("password") != null){
				map.put("password", MD5Util.MD5(map.get("password").toString()));
			}
			this.duserManager.modify(id, map);
			jsonObject.accumulate("suc", 0);
		} catch (Exception e) {
			// TODO: handle exception
			jsonObject.accumulate("suc", 1);
		}
		renderHtml(jsonObject.toString());
	}
	
	/*
	 * lzc
	 * 2015年1月26日09:14:32
	 * 
	 */
	public void register(){
		JSONObject jsonObject = new JSONObject();
		//假设验证码为123456    以后需要将判断条件分开
		if(validCode.equals("123456") && !duserManager.exist(id)){//模拟:验证码
			Duser user = new Duser();
			user.setId(id);
			user.setCreatetime(System.currentTimeMillis());
			duserManager.add(user);
			jsonObject.accumulate("suc", 0);
		}else{
			jsonObject.accumulate("suc", 2);
		}
		renderHtml(jsonObject.toString());
	}
	
	/*
	 * lzc
	 * 2015年1月26日09:42:22
	 */
	public void login(){
		JSONObject jsonObject = new JSONObject();
		//md5未添加
		if (this.duserManager.login(id, MD5Util.MD5(password))) {
			jsonObject.accumulate("suc", 0);
			jsonObject.accumulate("user", this.duserManager.get(id));
		} else {
			jsonObject.accumulate("suc", 1);
		}
		renderHtml(jsonObject.toString());
		
	}
	
	
	/*
	 * lzc
	 * 2015年1月23日13:22:01
	 * 查询手机是否已经注册
	 * 
	 */
	public void exist(){
		JSONObject jsonObject = new JSONObject();
		if(duserManager.exist(id)){
			jsonObject.accumulate("exist", 1);
		}else {
			jsonObject.accumulate("exist", 0);
			jsonObject.accumulate("validcode", "123456");//模拟:发送验证码
		}
		renderHtml(jsonObject.toString());
	}


	public IDuserManager getDuserManager() {
		return duserManager;
	}


	public void setDuserManager(IDuserManager duserManager) {
		this.duserManager = duserManager;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	

}
