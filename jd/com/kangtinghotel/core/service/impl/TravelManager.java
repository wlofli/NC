package com.kangtinghotel.core.service.impl;

import java.util.List;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Travel;
import com.kangtinghotel.core.service.ITravelManager;

public class TravelManager extends BaseSupport<Travel> implements ITravelManager{

	@Override
	public List<Travel> list() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from travel ", Travel.class);
	}

}
