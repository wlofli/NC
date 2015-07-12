package com.enation.core.service;

import java.util.List;

import com.enation.core.model.News;

public interface INewsManager {
	/*
	 * lzc
	 * 2015年4月3日13:05:06
	 * 获取资讯分页列表
	 */
	public List<News> list(int pageNo, int pageSize );
	
	/*
	 * lzc
	 * 2015年4月7日11:19:36
	 * 获取符合条件的资讯列表
	 */
	public List<News> list(int pageNo, int pageSize, News news, Long begin, Long end);
	
	
	/*
	 * lzc
	 * 2015年4月3日13:49:17
	 * 新增资讯
	 */
	public void add(News news);
	
	
	/*
	 * lzc
	 * 2015年4月7日10:01:24
	 * 获得详细资讯信息
	 */
	public News get(int id);
}
