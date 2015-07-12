package com.kangtinghotel.core.service.impl;

import java.util.List;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Activity;
import com.kangtinghotel.core.service.IActivityManager;

public class ActivityManager extends BaseSupport<Activity> implements IActivityManager{

	@Override
	public List<Activity> list() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from activity", Activity.class);
	}
	

}
