package com.enation.core.service;

import com.enation.core.model.Duser;

public interface IDuserManager {
	
	/*
	 * lzc
	 * 2015年4月7日09:33:45
	 * 登陆
	 * **返回用户放在session中
	 */
	public Duser login(String username);
}
