package com.enation.core.action;

import java.util.List;
import java.util.UUID;

import com.enation.core.model.Ana;
import com.enation.core.model.Block;
import com.enation.core.model.Indiv;
import com.enation.core.model.Industry;
import com.enation.core.model.News;
import com.enation.core.model.Record;
import com.enation.core.service.IAnaManager;
import com.enation.core.service.IIndivManager;
import com.enation.core.service.IRecordManager;
import com.enation.core.service.impl.BlockManager;
import com.enation.core.service.impl.IndustryManager;
import com.enation.framework.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;


/*
 * lzc
 * 资讯分析
 * 2015年4月7日11:03:46
 */
public class anaAction extends ZmtAction{
	private List<Block> blockList;
	private List<Indiv> indivList;
	private List<Industry> industryList;
	private IAnaManager anaManager;
	private IRecordManager recordManager;
	private IIndivManager indivManager;
	private IndustryManager industryManager;
	private BlockManager blockManager;
	private Ana ana;
	private News news;
	private int id;
	private Record record;
	
	/*
	 * lzc
	 * 2015年4月7日11:09:03
	 * 新增解读
	 */
	public String add(){
		this.logger.info("ana!add");
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		long time = System.currentTimeMillis();
		ana.setId(id);
		ana.setUserid(this.getUserId());
		ana.setName(this.getUserName());
		ana.setTime(time);
		ana.setDel((byte)0);
		this.anaManager.add(ana);
		System.out.println(indivList);
		System.out.println(industryList);
		System.out.println(blockList);
		if(indivList != null){
			//添加个股
			for(Indiv in: indivList){
				if(in == null || StringUtil.isEmpty(in.getName())) continue;
				in.setAnaid(id);
				this.indivManager.add(in);
			}
		}
		if(industryList != null){
			//添加行业
			for(Industry industry : industryList){
				if(industry == null) continue;
				industry.setAnaid(id);
				this.industryManager.add(industry);
			}
		}
		if(blockList != null){
			//添加板块
			for(Block block : blockList){
				if(block == null) continue;
				block.setAnaid(id);
				this.blockManager.add(block);
			}
		}
		Record record = new Record();
		record.setType((byte) 1);
		record.setTime(time);
		record.setUserid(this.getUserId());
		record.setName(this.getUserName());
		record.setTitle(news.getName());
		
		this.recordManager.add(record);
		return "add";
	}
	
	public IAnaManager getAnaManager() {
		return anaManager;
	}
	
	public void setAnaManager(IAnaManager anaManager) {
		this.anaManager = anaManager;
	}
	
	public Ana getAna() {
		return ana;
	}
	
	public void setAna(Ana ana) {
		this.ana = ana;
	}

	public List<Block> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<Block> blockList) {
		this.blockList = blockList;
	}

	public List<Indiv> getIndivList() {
		return indivList;
	}

	public void setIndivList(List<Indiv> indivList) {
		this.indivList = indivList;
	}

	public List<Industry> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(List<Industry> industryList) {
		this.industryList = industryList;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public IIndivManager getIndivManager() {
		return indivManager;
	}

	public void setIndivManager(IIndivManager indivManager) {
		this.indivManager = indivManager;
	}

	public IndustryManager getIndustryManager() {
		return industryManager;
	}

	public void setIndustryManager(IndustryManager industryManager) {
		this.industryManager = industryManager;
	}

	public BlockManager getBlockManager() {
		return blockManager;
	}

	public void setBlockManager(BlockManager blockManager) {
		this.blockManager = blockManager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IRecordManager getRecordManager() {
		return recordManager;
	}

	public void setRecordManager(IRecordManager recordManager) {
		this.recordManager = recordManager;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	
	
}
