package com.enation.core.service.impl;

import com.enation.core.model.Record;
import com.enation.core.service.IRecordManager;
import com.enation.framework.cache.AbstractCacheProxy;

public class RecordProxy extends AbstractCacheProxy<Record> implements IRecordManager{

	public RecordProxy() {
		super("record");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(Record record) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
