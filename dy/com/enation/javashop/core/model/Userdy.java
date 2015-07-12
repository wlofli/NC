package com.enation.javashop.core.model;

import java.io.Serializable;
import java.util.Date;

public class Userdy implements Serializable {
	private String user_id;
	private String dy_id;
	private int user_judge;
	private Date user_judgetime;
	private String p1;
	private String p2;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDy_id() {
		return dy_id;
	}

	public void setDy_id(String dy_id) {
		this.dy_id = dy_id;
	}

	public int getUser_judge() {
		return user_judge;
	}

	public void setUser_judge(int user_judge) {
		this.user_judge = user_judge;
	}

	public Date getUser_judgetime() {
		return user_judgetime;
	}

	public void setUser_judgetime(Date user_judgetime) {
		this.user_judgetime = user_judgetime;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

}
