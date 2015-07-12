package com.enation.core.service;

import java.util.List;

import com.enation.core.model.Duser;
import com.enation.core.model.Push;

public interface IPushManager {
	
	/*
	 * lzc
	 * 2015年4月15日10:22:29
	 * 添加
	 */
	public void add(Push push);
	
	/*
	 * lzc
	 * 2015年4月15日10:56:09
	 * 删除
	 */
	public void delete(int userid, int recordid);
	public void delete(int id);
	
	
	
	
}
