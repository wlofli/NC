package com.enation.javashop.core.model;

import java.io.Serializable;
import java.util.Date;

public class Version implements Serializable {
	private int v_id;
	private String v_name;
	private String v_num;// 版本号
	private String v_path;
	private String v_explain;
	private int v_up;// 强制升级标志
	private String v_size;
	private Date v_date;
	private String p1;
	private String p2;

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getV_num() {
		return v_num;
	}

	public void setV_num(String v_num) {
		this.v_num = v_num;
	}

	public String getV_path() {
		return v_path;
	}

	public void setV_path(String v_path) {
		this.v_path = v_path;
	}

	public String getV_explain() {
		return v_explain;
	}

	public void setV_explain(String v_explain) {
		this.v_explain = v_explain;
	}

	public int getV_up() {
		return v_up;
	}

	public void setV_up(int v_up) {
		this.v_up = v_up;
	}

	public String getV_size() {
		return v_size;
	}

	public void setV_size(String v_size) {
		this.v_size = v_size;
	}

	public Date getV_date() {
		return v_date;
	}

	public void setV_date(Date v_date) {
		this.v_date = v_date;
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
