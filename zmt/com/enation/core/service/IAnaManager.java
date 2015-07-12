package com.enation.core.service;

import com.enation.core.model.Ana;

public interface IAnaManager {
	/*
	 * lzc
	 * 2015年4月8日13:20:59
	 * 新增解读
	 */
	public void add(Ana ana);
	
	/*
	 * lzc
	 * 2015年4月15日09:48:50
	 * 获取解读
	 * id news主键
	 */
	public Ana get(int id);
	
	
	
}
