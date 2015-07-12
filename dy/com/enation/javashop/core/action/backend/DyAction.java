package com.enation.javashop.core.action.backend;

/*
 * ymy
 * 2014年12月31日10:51:19
 */
import java.io.PrintWriter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.enation.framework.action.WWAction;
import com.enation.javashop.core.model.Dy;
import com.enation.javashop.core.service.IDyManager;
import com.enation.javashop.core.service.IPictureManager;
import com.enation.javashop.core.service.IUserDyManager;

public class DyAction extends WWAction {

	private int type;
	private String dyid;
	private String dyname;
	private String content;
	private String userid;
	private Date createtime;
	private Long finaltime;
	private int choosey;
	private int choosen;
	private int state;
	private int pageNo;
	private String picture;
	private String p1;
	private IDyManager dyManager;
	private List<IDyManager> dylist;
	private IPictureManager pictureManager;
	private Dy dy;

	public String login() {
		switch (type) {
		case 1:
		}
		return null;

	}

	public String modify() {

		return null;
	}

	public String getmydy() {

		return null;
	}

	public String myjoindy() {
		List<Dy> dyList = dyManager.list(dyid);

		return null;
	}

	/*
	 * lzc 2015年1月6日17:09:42 返回dy 参数 type
	 */
	public String dy() {
		List<Dy> dyList = dyManager.list(type, pageNo, 15);
		JSONObject json = new JSONObject();
		if (!dyList.isEmpty()) {
			json.accumulate("suc", "0");
			json.accumulate("list", dyList);
		} else {
			json.accumulate("suc", "3");
		}
		renderHtml(json.toString());
		return null;
	}

	/*
	 * lzc 2015年1月7日10:17:28 添加DY
	 */
	public void add() {
		Dy dy = new Dy();
		dy.setDy_id(UUID.randomUUID().toString().replaceAll("-", ""));
		dy.setDy_name(dyname);
		dy.setDy_content(content);
		dy.setUser_id(userid);
		dy.setDy_finaltime(new Timestamp(finaltime));
		dy.setDy_delete(0);
		dy.setDy_picture(picture);
		dy.setDy_look(0);
		dy.setDy_choose(0);
		dy.setDy_choosey(0);
		dy.setDy_choosen(0);
		dy.setDy_open(0);
		dy.setDy_state(1);
		JSONObject json = new JSONObject();
		try {
			this.dyManager.add(dy);
			json.accumulate("suc", 0);
		} catch (Exception e) {
			// TODO: handle exception
			json.accumulate("suc", 2);
		}
		renderHtml(json.toString());
	}

	/*
	 * lzc 2015年1月7日14:30:39 设置结果
	 */
	public void setresult() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dy_state", state);
		JSONObject json = new JSONObject();
		try {
			dyManager.setResult(map, dyid);
			json.accumulate("suc", "0");
		} catch (Exception e) {
			// TODO: handle exception
			json.accumulate("suc", "2");
		}
		renderHtml(json.toString());
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDyid() {
		return dyid;
	}

	public void setDyid(String dyid) {
		this.dyid = dyid;
	}

	public String getDyname() {
		return dyname;
	}

	public void setDyname(String dyname) {
		this.dyname = dyname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getFinaltime() {
		return finaltime;
	}

	public void setFinaltime(Long finaltime) {
		this.finaltime = finaltime;
	}

	public int getChoosey() {
		return choosey;
	}

	public void setChoosey(int choosey) {
		this.choosey = choosey;
	}

	public int getChoosen() {
		return choosen;
	}

	public void setChoosen(int choosen) {
		this.choosen = choosen;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
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

	public Dy getDy() {
		return dy;
	}

	public void setDy(Dy dy) {
		this.dy = dy;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
