package com.enation.javashop.core.service;

import java.util.List;
import java.util.Map;

import com.enation.javashop.core.model.Duser;

public interface IDuserManager {

	/*
	 * lzc 添加用户 2014年12月29日18:55:32
	 */
	public void add(Duser user);

	/*
	 * lzc 修改用户 2014年12月29日18:55:53
	 */

	public void save(Duser user);

	public void save(Map value, String userid);

	/*
	 * lzc 获取用户 2014年12月30日16:38:14
	 */
	public Duser get(String id);

	public Duser get(String id, String username, int sex, String addr,
			String avtar);

	/*
	 * lzc 查询账户是否存在 type=1 IMEI号码 2 QQ
	 */
	public boolean exist(String id);

	/*
	 * lzc 返回所有用户列表
	 */
	public List<Duser> list();

}
