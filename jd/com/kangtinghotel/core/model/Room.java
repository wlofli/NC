package com.kangtinghotel.core.model;

import java.io.Serializable;

public class Room implements Serializable{
	private String id;
	private String num;
	private String name;
	private int floor;
	private String hotelid;
	private String url;
	private int pricep;//牌价
	private int pricems;//门市价
	private int priceht;//合同价
	private int pricemen;//会员价
	private int type;
	private int state;
	private int window;
	private int computer;
	private int water;
	private int washroom;
	private String size;
	private String info;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPricep() {
		return pricep;
	}
	public void setPricep(int pricep) {
		this.pricep = pricep;
	}
	public int getPricems() {
		return pricems;
	}
	public void setPricems(int pricems) {
		this.pricems = pricems;
	}
	public int getPriceht() {
		return priceht;
	}
	public void setPriceht(int priceht) {
		this.priceht = priceht;
	}
	public int getPricemen() {
		return pricemen;
	}
	public void setPricemen(int pricemen) {
		this.pricemen = pricemen;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getWindow() {
		return window;
	}
	public void setWindow(int window) {
		this.window = window;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getWashroom() {
		return washroom;
	}
	public void setWashroom(int washroom) {
		this.washroom = washroom;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	
	
}
