package com.kangtinghotel.core.service.impl;

import java.util.List;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Room;
import com.kangtinghotel.core.service.IRoomManager;

public class RoomManager extends BaseSupport<Room> implements IRoomManager{
	@Override
	public List<Room> list(Long beginTime, Long endTime) {
		// TODO Auto-generated method stub
		String sql = "select * from room where id not in" +
				"(select roomid from es_roomorder WHERE es_roomorder.begintime <= ? and es_roomorder.endtime >= ?)";
		return this.baseDaoSupport.queryForList(sql, Room.class, endTime, beginTime);//注意俩个参数的顺序
	}

}
