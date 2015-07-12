package com.kangtinghotel.core.service.impl;

import java.util.List;

import com.enation.eop.sdk.database.BaseSupport;
import com.kangtinghotel.core.model.Products;
import com.kangtinghotel.core.service.IProductsManager;

public class ProductsManager extends BaseSupport<Products> implements IProductsManager{

	@Override
	public List<Products> list() {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForList("select * from products", Products.class);
	}

}
