package com.enation.core.action;

import com.enation.core.model.Comment;
import com.enation.core.service.ICommentManager;

public class comAction extends ZmtAction{
	private String infoid;
	private Comment comment;
	private int type;
	private String typeid;
	private ICommentManager commentManager;
	/*
	 * 新增评论
	 * lzc
	 * 2015年4月8日13:20:03
	 */
	public String add(){
		comment.setUserid(getUserId());
		comment.setName(getUserName());
		comment.setTime(System.currentTimeMillis());
		this.commentManager.add(comment);
		return "add";
	}
	
	public void getList(){
		this.commentManager.list(type, typeid);
		
	}

	public String getInfoid() {
		return infoid;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public ICommentManager getCommentManager() {
		return commentManager;
	}

	public void setCommentManager(ICommentManager commentManager) {
		this.commentManager = commentManager;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
}
