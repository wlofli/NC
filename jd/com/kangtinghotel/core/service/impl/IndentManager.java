package com.kangtinghotel.core.service.impl;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Indent;
import com.kangtinghotel.core.service.IIndentManager;

public class IndentManager extends BaseSupport<Indent> implements IIndentManager{

	@Override
	public void add(Indent indent) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("indent", indent);
	}

}
