package com.kangtinghotel.core.action.backend;

import java.io.File;
import java.sql.Timestamp;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.enation.eop.sdk.context.EopSetting;
import com.enation.framework.action.WWAction;
import com.enation.framework.util.FileUtil;
import com.kangtinghotel.constant.DefaultConstant;
import com.kangtinghotel.core.model.Picture;
import com.kangtinghotel.core.service.IPictureManager;
import com.kangtinghotel.core.util.Base64Util;
import com.kangtinghotel.core.util.ImageUtils;

public class PictureAction  extends WWAction{
	
	private String filePath;
	private File file;
	private String fileName;
	private String fileBase64;
	private IPictureManager pictureManager;
	private String id;
	
	/*
	 * lzc
	 * 2015年1月27日19:55:02
	 * 上传图片
	 * 静态资源合并模式
	 */
	public void upfile(){
System.out.println("upfile");
		JSONObject json = new JSONObject();
		String name = Long.toString(System.currentTimeMillis()) + fileName;
		String url = DefaultConstant.DEFAULT_IMAGE_PATH+name;
		try {
			String filePath = EopSetting.IMG_SERVER_PATH + name;
			String waterFilePath = DefaultConstant.SERVICE_IMAGE_PATH + name;//最终水印文件路径
			this.file = Base64Util.string2File(fileBase64, filePath);
			System.out.println(file.getPath());
			ImageUtils.pressImage(file.getPath(), DefaultConstant.SERVICE_IMAGE_WATER, waterFilePath, 0, 0, 720, false);
			File waterFile = new File(waterFilePath);
			while(waterFile.length() >= 524288){
				ImageUtils.resize(waterFilePath, waterFilePath, 720, 0.9f);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			json.accumulate("suc", "5");
		}
		Picture	picture = new Picture();
		picture.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		picture.setType(2);//默认为缩略图
		picture.setUserid(id);
		picture.setUptime(System.currentTimeMillis());
		picture.setPrename(fileName);
		picture.setName(name);
		picture.setFormat(FileUtil.getFileExt(fileName));
//		picture.setSize(file);
		picture.setUrl(url);
		this.pictureManager.add(picture);
		json.accumulate("picture", url);//undone
		json.accumulate("suc", "0");
		renderHtml(json.toString());
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public IPictureManager getPictureManager() {
		return pictureManager;
	}

	public void setPictureManager(IPictureManager pictureManager) {
		this.pictureManager = pictureManager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
