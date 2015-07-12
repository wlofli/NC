package com.enation.javashop.core.service;

/*
 * ymy
 * 2015年1月5日16:20:11
 */
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.taskdefs.compilers.Sj;

import sun.nio.cs.ext.SJIS_0213;

import com.enation.javashop.core.model.Duser;
import com.enation.javashop.core.model.Dy;
import com.enation.javashop.core.model.Version;

public interface IDyManager {

	/*
	 * lzc 2014年12月29日14:20:13 添加Dy
	 */
	public void add(Dy dy);

	/*
	 * lzc 修改dy结果状态 2014年12月29日18:58:23
	 */
	public void setResult(Map map, String id);

	/*
	 * lzc 修改dy结果状态 2014年12月30日14:54:35
	 */
	public Dy get(String dyid);

	public void setResult(String dyid, int state);

	/*
	 * lzc 获取DYlist 2014年12月31日10:03:45
	 */
	public List<Dy> list(String userid);

	public List<Dy> list(int type, int pageNo, int pageSize);// lzc

	/*
	 * ymy 获取内容2015年1月5日18:38:56
	 */
	public void get(String content, int type);

	/*
	 * ymy choosey字段名称 value字段值 获取选择Y的人数 2015年1月5日19:05:10
	 */
	public void update(Integer choosey, Object value);

	/*
	 * ymy choosen字段名称 value字段值 获取选择N的人数 2015年1月5日19:06:23
	 */
	public void updatedy(Integer choosen, Object value);

	/*
	 * ymy 公布答案时间 2015年1月5日19:51:26
	 */

	public void get(Date finaltime);

	/*
	 * ymy 2015年1月5日19:55:07 1:未公布 2:选择Y 3:选择N
	 */
	public int get(Integer state);

}
