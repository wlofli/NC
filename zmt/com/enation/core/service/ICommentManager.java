package com.enation.core.service;

import java.util.List;

import com.enation.core.model.Comment;

public interface ICommentManager {
	
	/*
	 * lzc
	 * 2015年4月7日10:50:02
	 * 增加评论
	 */
	public void add(Comment comment);
	
	
	/*
	 * lzc
	 * 2015年4月15日10:13:09
	 * 获取评论列表
	 */
	public List<Comment> list(int type, String typeid);
}
