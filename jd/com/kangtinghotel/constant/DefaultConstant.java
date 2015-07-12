package com.kangtinghotel.constant;

import com.enation.eop.sdk.context.EopSetting;

public class DefaultConstant {
	
	public static String DEFAULT_IMAGE_PATH = EopSetting.IMG_SERVER_DOMAIN + "/JD/images/";//图片默认存放位置
	public static String DEFAULT_WATERIMAGE = EopSetting.IMG_SERVER_DOMAIN + "/JD/images/water.png";
	//以下存放位置的图片都是水印加重新设置大小过的图片
	public static String DEFAULT_HEAD = EopSetting.IMG_SERVER_DOMAIN + "/JD/head/";//头像存放位置
	public static String DEFAULT_FOOD = EopSetting.IMG_SERVER_DOMAIN + "/JD/food/";//餐品图片存放位置
	public static String DEFAULT_ACTIVITY = EopSetting.IMG_SERVER_DOMAIN + "/JD/activity/";//活动图片存放位置
	public static String DEFAULT_PRODUCT = EopSetting.IMG_SERVER_DOMAIN + "/JD/product/";//商品图片存放位置
	public static String DEFAULT_ROOM = EopSetting.IMG_SERVER_DOMAIN + "/JD/room/";//房间图片存放位置
	public static String DEFAULT_TRAVEL = EopSetting.IMG_SERVER_DOMAIN + "/JD/travel/";//活动存放位置
	
	
	
	//服务器程序获取文件路径
	public static String SERVICE_IMAGE_PATH = 
			"E:/QW/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/jd/statics/JD/images/";
	public static String SERVICE_IMAGE_WATER = 
			"E:/QW/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/jd/statics/JD/images/water.png";

}
