package com.kangtinghotel.core.model;

import java.io.Serializable;

public class Indent implements Serializable{
	private String id;
	private String userid;
	private String hotelid;
	private String username;
	private Long checktime;
	private Long begintime;
	private Long endtime;
	private int checkprice;//结算金额
	private int realprice;//实付金额
	private int state;//订单状态
	private int proprice;//商品金额
	private String p1;
	private String p2;
	private String p3;
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
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getChecktime() {
		return checktime;
	}
	public void setChecktime(Long checktime) {
		this.checktime = checktime;
	}
	public Long getBegintime() {
		return begintime;
	}
	public void setBegintime(Long begintime) {
		this.begintime = begintime;
	}
	public Long getEndtime() {
		return endtime;
	}
	public void setEndtime(Long endtime) {
		this.endtime = endtime;
	}
	public int getCheckprice() {
		return checkprice;
	}
	public void setCheckprice(int checkprice) {
		this.checkprice = checkprice;
	}
	public int getRealprice() {
		return realprice;
	}
	public void setRealprice(int realprice) {
		this.realprice = realprice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}

}
