package com.enation.core.action;


import com.enation.core.model.Duser;
import com.enation.core.service.IDuserManager;
import com.opensymphony.xwork2.ActionContext;

public class duserAction extends ZmtAction{
	private String username;
	private String password;
	private IDuserManager duserManager;

	/*
	 * lzc
	 * 2015年4月7日09:57:30
	 * 登陆
	 */
	public String login(){
		System.out.println("login");
		Duser duser = new Duser();
		duser = this.duserManager.login(username);
		if(duser.getPassword().equals(password)){
			ActionContext.getContext().getSession().put("userid", duser.getId());
			ActionContext.getContext().getSession().put("name", duser.getName());
			ActionContext.getContext().getSession().put("username", duser.getUsername());
			return "login";
		}else {
			return "error";
		}
	
		//WebSessionContext<UserContext> sessonContext = ThreadContextHolder.getSessionContext();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IDuserManager getDuserManager() {
		return duserManager;
	}

	public void setDuserManager(IDuserManager duserManager) {
		this.duserManager = duserManager;
	}
}
