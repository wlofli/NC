package com.enation.javashop.core.service.impl;

import com.enation.eop.sdk.database.BaseSupport;
import com.enation.javashop.core.model.Version;
import com.enation.javashop.core.service.IVersionManager;
import com.sun.org.apache.bcel.internal.generic.Select;

public class VersionManager extends BaseSupport<Version> implements
		IVersionManager {

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport
				.queryForString("select v_num from version where v_id = "
						+ "(select max(v_id) from version)");
	}

	@Override
	public void add(Version version) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("version", version);
	}

	@Override
	public Version get(String num) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject(
				"select * from version where v_num = ?", Version.class, num);
	}

	@Override
	public String getPath(String num) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport
				.queryForString("select v_path from version where v_num = '"
						+ num + "'");
	}

}
