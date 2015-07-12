package com.enation.javashop.core.model;

import java.io.Serializable;
import java.sql.Date;

public class Picture implements Serializable {
	private String p_id;
	private int p_type;
	private String use_id;
	private String dy_id;
	private Date p_uptime;
	private int p_size;
	private String p_name;
	private String p_prename;
	private int p_wid;
	private int p_height;
	private String p_format;
	private String p_url;

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public int getP_type() {
		return p_type;
	}

	public void setP_type(int p_type) {
		this.p_type = p_type;
	}

	public String getUse_id() {
		return use_id;
	}

	public void setUse_id(String use_id) {
		this.use_id = use_id;
	}

	public String getDy_id() {
		return dy_id;
	}

	public void setDy_id(String dy_id) {
		this.dy_id = dy_id;
	}

	public Date getP_uptime() {
		return p_uptime;
	}

	public void setP_uptime(Date p_uptime) {
		this.p_uptime = p_uptime;
	}

	public int getP_size() {
		return p_size;
	}

	public void setP_size(int p_size) {
		this.p_size = p_size;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_prename() {
		return p_prename;
	}

	public void setP_prename(String p_prename) {
		this.p_prename = p_prename;
	}

	public int getP_wid() {
		return p_wid;
	}

	public void setP_wid(int p_wid) {
		this.p_wid = p_wid;
	}

	public int getP_height() {
		return p_height;
	}

	public void setP_height(int p_height) {
		this.p_height = p_height;
	}

	public String getP_format() {
		return p_format;
	}

	public void setP_format(String p_format) {
		this.p_format = p_format;
	}

	public String getP_url() {
		return p_url;
	}

	public void setP_url(String p_url) {
		this.p_url = p_url;
	}

}
