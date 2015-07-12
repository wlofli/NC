package com.enation.core.service;

import java.util.List;

import com.enation.core.model.Block;

public interface IBlockManager {

	/*
	 * lzc
	 * 2015年4月14日15:57:00
	 * 添加
	 */
	public void add(Block block);
	
	
	
	/*
	 * lzc
	 * 2015年4月15日10:10:05
	 * 获取板块列表
	 */
	public List<Block> list(String id);
}
