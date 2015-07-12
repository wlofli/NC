package com.enation.core.service.impl;

import java.util.List;

import com.enation.core.model.Comment;
import com.enation.core.service.ICommentManager;
import com.enation.eop.sdk.database.BaseSupport;

public class CommentManager extends BaseSupport<Comment> implements ICommentManager{

	@Override
	public void add(Comment comment) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("comment", comment);
	}

	@Override
	public List<Comment> list(int type, String typeid) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from comment where type = ? and typeid = ? order by time ", Comment.class, type, typeid);
	}

}
