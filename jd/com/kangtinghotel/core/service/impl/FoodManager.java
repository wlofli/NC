package com.kangtinghotel.core.service.impl;

import java.util.List;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Food;
import com.kangtinghotel.core.service.IFoodManager;

public class FoodManager extends BaseSupport<Food> implements IFoodManager{

	@Override
	public List<Food> list() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from food", Food.class);
	}

}
