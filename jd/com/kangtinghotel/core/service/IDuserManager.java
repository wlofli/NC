package com.kangtinghotel.core.service;

import java.util.Map;

import com.kangtinghotel.core.model.Duser;

/*
 * lzc
 * 2015年1月23日11:39:16
 */
public interface IDuserManager  {
	
	/*
	 * lzc
	 * 2015年1月27日10:32:38
	 */
	public Duser get(String id);
	/*
	 * lzc
	 * 2015年1月26日10:58:21
	 * 修改个人信息
	 */
	public void modify(String id, Map map);
	public void modify(String id, String password);//修改密码
	/*
	 * lzc
	 * 2015年1月23日12:54:24
	 * 添加用户
	 */
	public void add(Duser user);
	
	
	/*
	 * lzc
	 * 2015年1月23日12:55:10
	 * 查询用户是否存在
	 * true 存在
	 * false 不存在
	 */
	public boolean exist(String id);
	public boolean exist(String id, String password);
	
	
	public boolean login(String id, String password);
}
