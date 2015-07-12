package com.enation.javashop.core.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.enation.javashop.core.model.Userdy;

public interface IUserDyManager {

	/*
	 * lzc 2014年12月29日19:04:39 添加用户参与的DY
	 */
	public void add(Map map);

	/*
	 * lzc 2014年12月29日19:05:04 返回用于参与的DY
	 */
	public List<Userdy> list(String userid);

	public List<Userdy> list(String userid, Date time, int islatest, int limit);

	/*
	 * lzc 2014年12月29日19:30:47 1:存在数据 0:不存在
	 */
	public int get(String name, int type);

}
