package com.enation.core.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

public abstract class ZmtAction  {
	protected Logger logger = Logger.getLogger(getClass());
	
	
	
	public String getUserName(){
		try {
			String username = ActionContext.getContext().getSession().get("username").toString();
			return username;
		} catch (Exception e) {
			// TODO: handle exception
		}
			return null;
	}
	
	
	public int getUserId(){
		try {
			int i = Integer.parseInt(ActionContext.getContext().getSession().get("userid").toString());
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
}
