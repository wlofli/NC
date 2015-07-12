package com.kangtinghotel.core.service;

import java.util.List;

import com.kangtinghotel.core.model.Room;

public interface IRoomManager {
	/*
	 * lzc
	 * 2015年1月26日16:06:31
	 * 获取该段时间空余客房
	 */
	public List<Room> list(Long beginTime, Long endTime);

}
