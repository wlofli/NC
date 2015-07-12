package com.enation.core.service;

import com.enation.core.model.Record;

public interface IRecordManager {
	
	/*
	 * lzc
	 * 2015年4月3日16:53:00
	 * 返回记录表里的资讯与解读总数
	 */
	public int count();

	
	/*
	 * lzc
	 * 2015年4月15日10:38:17
	 * 添加记录
	 */
	public void add(Record record);
}
