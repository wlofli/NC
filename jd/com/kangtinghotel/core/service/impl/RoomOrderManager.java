package com.kangtinghotel.core.service.impl;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Indent;
import com.kangtinghotel.core.model.RoomOrder;
import com.kangtinghotel.core.service.IRoomOrderManager;

public class RoomOrderManager extends BaseSupport<RoomOrder> implements IRoomOrderManager{

	@Override
	public void add(RoomOrder roomOrder) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("roomorder", roomOrder);
	}
	

}
