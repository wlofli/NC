package com.enation.core.service.impl;

import com.enation.core.model.Record;
import com.enation.core.service.IRecordManager;
import com.enation.eop.sdk.database.BaseSupport;

public class RecordManager extends BaseSupport<Record> implements IRecordManager{

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForInt("select count(*) from record");
	}

	@Override
	public void add(Record record) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("record", record);
	}

}
