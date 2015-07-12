package com.enation.javashop.core.action.backend;

import java.io.File;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.enation.eop.sdk.utils.UploadUtil;
import com.enation.framework.action.WWAction;
import com.enation.framework.util.RequestUtil;
import com.enation.javashop.core.model.Duser;
import com.enation.javashop.core.model.Dy;
import com.enation.javashop.core.model.Userdy;
import com.enation.javashop.core.service.IDuserManager;
import com.enation.javashop.core.service.IDyManager;
import com.enation.javashop.core.service.IPictureManager;
import com.enation.javashop.core.service.IUserDyManager;
import net.sf.json.JSONObject;

public class DuserAction extends WWAction {

	private int type;
	private String username;
	private String weibo;
	private int sex;
	private String avtar;
	private String addr;
	private String password;
	private String id;
	private IDuserManager duserManager;
	private IUserDyManager userDyManager;
	private int limit;
	private Long time;
	private int islatest;
	private IDyManager dyManager;
	private List<IDyManager> dylist;
	private IPictureManager pictureManager;
	private Duser duser;
	private File file;
	private String fileName;
	private static final String subfolder = "/iamgs";

	public String test() {
		return "test";
	}

	public String suc() {
		return "suc";
	}

	public void upHead() {
		UploadUtil.upload(file, fileName, subfolder);
	}

	/*
	 * lzc 2015年1月5日18:19:33 第三方id登入
	 */
	public String login() {
		if (!this.duserManager.exist(id)) {// 如果是第一次登入,则注册
			register();
		}
		JSONObject json = new JSONObject();
		Duser user = this.duserManager.get(id, username, sex, addr, avtar);
		if (user == null) {
			json.accumulate("suc", "1");// 第三方参数出错与数据库不匹配;
		} else {
			json.accumulate("suc", "0");
			json.accumulate("userid", user.getUser_id());
		}
		renderText(json.toString());
		return null;
	}

	/*
	 * lzc 2015年1月5日18:20:10 查询账户是否存在
	 */
	public void check() {
		System.out.println("check");
		JSONObject json = new JSONObject();
		if (!this.duserManager.exist(username)) {
			json.accumulate("result", 0);
			json.accumulate("user", "不存在");
		} else {
			json.accumulate("result", 1);
			json.accumulate("user", "存在");
		}
		renderText(json.toString());

	}

	/*
	 * lzc 2015年1月5日18:21:41 注册
	 */
	public void register() {
		duser = new Duser();
		duser.setUser_id(UUID.randomUUID().toString().replaceAll("-", ""));
		duser.setUser_weibo(id);
		duser.setUser_name(username);
		duser.setUser_sex(sex);
		duser.setUser_addr(addr);
		duser.setUser_head(avtar);
		duser.setUser_exp(0);
		duser.setLogin_time(System.currentTimeMillis());
		duser.setUser_create(0);
		duser.setUser_partcipate(0);
		duser.setUser_suc(0);
		duser.setUser_power((long) 100000000);
		this.duserManager.add(duser);
	}

	public String modify() {
		Map map = RequestUtil.paramToMap(this.getRequest());
		setId((String) map.get("id"));
		this.duserManager.save(map, id);
		return null;
	}

	public void getmydy() {
		JSONObject json = new JSONObject();
		json.accumulate("result", "0");
		json.accumulate("list", dyManager.list(id));
		renderHtml(json.toString());
	}

	/*
	 * lzc 2015年1月8日08:49:38 获取个人参与的DY列表
	 */
	public void myjoindy() {
		// List<Dy> dyList = dyManager.list(id);
		JSONObject json = new JSONObject();
		if (time == null) {
			time = System.currentTimeMillis();
		}
		List<Userdy> userdyList = userDyManager.list(id, new Timestamp(time),
				islatest, limit);
		Iterator<Userdy> it = userdyList.iterator();
		Map<String, Dy> map = new HashMap<String, Dy>();
		// while(it.hasNext()){
		// Userdy ud = new Userdy();
		// ud = it.next();
		// map.put(it.next(), value)
		//
		// }
		if (!userdyList.isEmpty()) {
			json.accumulate("suc", "0");
			json.accumulate("list", userdyList);
		} else {
			json.accumulate("suc", "3");
		}
		renderHtml(json.toString());
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IUserDyManager getUserDyManager() {
		return userDyManager;
	}

	public void setUserDyManager(IUserDyManager userDyManager) {
		this.userDyManager = userDyManager;
	}

	public IDyManager getDyManager() {
		return dyManager;
	}

	public void setDyManager(IDyManager dyManager) {
		this.dyManager = dyManager;
	}

	public List<IDyManager> getDylist() {
		return dylist;
	}

	public void setDylist(List<IDyManager> dylist) {
		this.dylist = dylist;
	}

	public IPictureManager getPictureManager() {
		return pictureManager;
	}

	public void setPictureManager(IPictureManager pictureManager) {
		this.pictureManager = pictureManager;
	}

	public IDuserManager getDuserManager() {
		return duserManager;
	}

	public void setDuserManager(IDuserManager duserManager) {
		this.duserManager = duserManager;
	}

	public Duser getDuser() {
		return duser;
	}

	public void setDuser(Duser duser) {
		this.duser = duser;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public static String getSubfolder() {
		return subfolder;
	}

	public String getAvtar() {
		return avtar;
	}

	public void setAvtar(String avtar) {
		this.avtar = avtar;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public int getIslatest() {
		return islatest;
	}

	public void setIslatest(int islatest) {
		this.islatest = islatest;
	}

}
