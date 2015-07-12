package com.enation.javashop.core.service;

import com.enation.javashop.core.model.Version;

public interface IVersionManager {

	/*
	 * lzc 2014年12月30日17:03:27 获取版本号
	 */
	public String getVersion();

	/*
	 * lzc 2014年12月30日17:05:25 添加版本信息
	 */
	public void add(Version version);

	/*
	 * lzc 2014年12月30日17:30:38 获取最新版本信息
	 */
	public Version get(String num);

	/*
	 * lzc 2015年1月7日09:42:13 获取版本路径
	 */
	public String getPath(String num);

}
