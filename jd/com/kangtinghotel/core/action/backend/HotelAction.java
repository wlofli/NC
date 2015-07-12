package com.kangtinghotel.core.action.backend;

import java.util.UUID;

import net.sf.json.JSONObject;

import com.enation.framework.action.WWAction;
import com.kangtinghotel.core.model.Indent;
import com.kangtinghotel.core.model.RoomOrder;
import com.kangtinghotel.core.service.IActivityManager;
import com.kangtinghotel.core.service.IFoodManager;
import com.kangtinghotel.core.service.IIndentManager;
import com.kangtinghotel.core.service.IProductsManager;
import com.kangtinghotel.core.service.IRoomManager;
import com.kangtinghotel.core.service.IRoomOrderManager;
import com.kangtinghotel.core.service.ITravelManager;

public class HotelAction  extends WWAction{
	private IProductsManager productsManager;
	private IIndentManager indentManager;
	private IRoomOrderManager roomOrderManager;
	private IRoomManager roomManager;
	private ITravelManager travelManager;
	private IFoodManager foodManager;
	private IActivityManager activityManager;
	private String id;
	private String userName;
	private Long beginTime;
	private Long endTime;
	private String roomid;
	
	
	
	
	
	
	/*
	 * lzc
	 * 2015年1月27日09:22:55
	 */
	public void activityList(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("list", this.activityManager.list());
		jsonObject.accumulate("suc", 0);
		renderHtml(jsonObject.toString());
	}
	
	
	
	/*
	 * lzc
	 * 2015年1月27日09:22:00
	 */
	public void foodList(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("list", this.foodManager.list());
		jsonObject.accumulate("suc", 0);
		renderHtml(jsonObject.toString());
	}
	
	
	
	/*
	 * lzc
	 * 2015年1月27日08:43:55
	 * 
	 */
	public void travelList(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("list", this.travelManager.list());
		jsonObject.accumulate("suc", 0);
		renderHtml(jsonObject.toString());
	}
	
	
	/*
	 * lzc
	 * 2015年1月26日16:29:23
	 */
	public void emptyroom(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("list", this.roomManager.list(beginTime, endTime));
		jsonObject.accumulate("suc", 0);
		renderHtml(jsonObject.toString());
	}
	/*
	 * lzc
	 * 2015年1月26日12:52:46
	 * 预订房间 
	 */
	public void order(){
		JSONObject jsonObject = new JSONObject();
		Indent indent = new Indent();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		indent.setId(uuid);
		indent.setUserid(id);
		indent.setHotelid("1");//default:1;
		indent.setUsername(userName);
		indent.setChecktime(System.currentTimeMillis());
		indent.setBegintime(beginTime);
		indent.setEndtime(endTime);
		this.indentManager.add(indent);
		RoomOrder roomOrder = new RoomOrder();
		roomOrder.setOrderid(uuid);
		roomOrder.setRoomid(roomid);
		roomOrder.setBegintime(beginTime);
		roomOrder.setEndtime(endTime);
		this.roomOrderManager.add(roomOrder);
		jsonObject.accumulate("suc", 0);
		jsonObject.accumulate("orderid", uuid);
		renderHtml(jsonObject.toString());
	}
	
	
	/*
	 * lzc
	 * 2015年1月26日11:43:42
	 * 获取产品列表
	 */
	public void productList(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("list", this.productsManager.list());
		renderHtml(jsonObject.toString());
	}


	
	
	public IProductsManager getProductsManager() {
		return productsManager;
	}


	public void setProductsManager(IProductsManager productsManager) {
		this.productsManager = productsManager;
	}


	public IIndentManager getIndentManager() {
		return indentManager;
	}


	public void setIndentManager(IIndentManager indentManager) {
		this.indentManager = indentManager;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Long getBeginTime() {
		return beginTime;
	}


	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}


	public Long getEndTime() {
		return endTime;
	}


	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}


	public String getRoomid() {
		return roomid;
	}


	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}


	public IRoomOrderManager getRoomOrderManager() {
		return roomOrderManager;
	}


	public void setRoomOrderManager(IRoomOrderManager roomOrderManager) {
		this.roomOrderManager = roomOrderManager;
	}
	public IRoomManager getRoomManager() {
		return roomManager;
	}
	public void setRoomManager(IRoomManager roomManager) {
		this.roomManager = roomManager;
	}
	public ITravelManager getTravelManager() {
		return travelManager;
	}
	public void setTravelManager(ITravelManager travelManager) {
		this.travelManager = travelManager;
	}


	public IFoodManager getFoodManager() {
		return foodManager;
	}


	public void setFoodManager(IFoodManager foodManager) {
		this.foodManager = foodManager;
	}


	public IActivityManager getActivityManager() {
		return activityManager;
	}


	public void setActivityManager(IActivityManager activityManager) {
		this.activityManager = activityManager;
	}

	
	
	
}
