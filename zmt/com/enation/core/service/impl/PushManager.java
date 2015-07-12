package com.enation.core.service.impl;

import com.enation.core.model.Push;
import com.enation.core.service.IPushManager;
import com.enation.eop.sdk.database.BaseSupport;

public class PushManager extends BaseSupport<Push> implements IPushManager {

	@Override
	public void add(Push push) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("Push", push);
	}

	@Override
	public void delete(int userid, int recordid) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.execute("delete from push where userid = ? and recordid = ? ", userid, recordid);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.execute("delete from push where id = ? ", id);
	}

}
