package com.enation.core.service.impl;

import java.util.List;

import com.enation.core.model.Block;
import com.enation.core.service.IBlockManager;
import com.enation.eop.sdk.database.BaseSupport;

public class BlockManager extends BaseSupport<Block> implements IBlockManager{

	@Override
	public void add(Block block) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("block", block);
	}

	@Override
	public List<Block> list(String id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from block where anaid = ? ", Block.class, id);
	}

}
