package com.enation.core.service;

import java.util.List;

import com.enation.core.model.Industry;

public interface IIndustryManager {
	/*
	 * 2015年4月15日10:11:49
	 * lzc
	 * 添加
	 */
	public void add(Industry industry);

	
	/*
	 * lzc
	 * 2015年4月15日10:12:01
	 * 获取行业列表
	 */
	public List<Industry> list(String id);
}
