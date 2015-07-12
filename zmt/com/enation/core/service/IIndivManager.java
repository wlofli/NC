package com.enation.core.service;

import java.util.List;

import com.enation.core.model.Indiv;

public interface IIndivManager {
	
	/*
	 * 2015年4月14日15:50:20
	 * lzc
	 * 新增
	 */
	public void add(Indiv indiv);
	
	
	/*
	 * lzc
	 * 2015年4月15日10:10:58
	 * 获取个股列表
	 */
	public List<Indiv> list(String id);
}
