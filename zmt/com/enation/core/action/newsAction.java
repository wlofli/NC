package com.enation.core.action;



import com.enation.core.model.Ana;
import com.enation.core.model.News;
import com.enation.core.model.Record;
import com.enation.core.service.IAnaManager;
import com.enation.core.service.IIndivManager;
import com.enation.core.service.INewsManager;
import com.enation.core.service.IRecordManager;
import com.enation.core.service.impl.BlockManager;
import com.enation.core.service.impl.IndustryManager;
import com.enation.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;

public class newsAction extends ZmtAction{
	private IRecordManager recordManager;
	private INewsManager newsManager;
	private IAnaManager anaManager;
	private IIndivManager indivManager;
	private IndustryManager industryManager;
	private BlockManager blockManager;
	private long startTime;
	private long endTime;
	private int id;
	private String name;
	private News news;
	private Ana ana;
	private int pageNo;
	private int pageSize;
	
	/*
	 * lzc
	 * 2015年4月7日11:00:11
	 * 进入添加资讯界面
	 */
	public String turnAdd(){
		return "turnAdd";
	}
	
	public String turnNewsList(){
		return "turnNewsList";
	}
	
	public String turnIndex(){
		return "turnIndex";
	}
	/*
	 * lzc
	 * 2015年4月21日09:06:10
	 * 返回详资讯详情界面
	 */
	public String turnCnt(){
		
		return "turnCnt";
	}
	
	/*
	 * lzc
	 * 2015年4月7日11:00:16
	 * 进入资讯列表界面
	 * 
	 * 需要添加ana联表查询
	 */
	public String list(){
		this.logger.info("news!list()");
		//pageSize = pageSize == 0 ? 8 :pageSize;
		pageNo = pageNo < 1 ? 1 : pageNo; 
		ActionContext.getContext().put("list", this.newsManager.list(pageNo, 8));
		return "list";
	}
	
	/*
	 * lzc
	 * 2015年4月27日09:26:49
	 * 按照条件获取资讯列表
	 */
	public String listByCondition(){
		this.logger.info("news!listByCondition()");
		pageNo = pageNo < 1 ? 1 : pageNo; 
		ActionContext.getContext().put("list", this.newsManager.list(pageNo, 8, news, startTime, endTime));
		return "list";
	}
	
	/*
	 * lzc
	 * 2015年4月7日11:00:35
	 * 添加资讯
	 */
	public String add(){
		System.out.println(news.getOne());
		long time = System.currentTimeMillis();
		news.setTime(time);
		news.setUserid(getUserId());
		news.setUsername(getUserName());
		news.setDel((byte)0);
		this.newsManager.add(news);
		Record record = new Record();
		record.setType((byte) 1);
		record.setTime(time);
		record.setUserid(getUserId());
		record.setName(getUserName());
		record.setTitle(news.getName());
		this.recordManager.add(record);
		return "add";
	}
	
	/*
	 * lzc
	 * 2015年4月7日11:00:53
	 * 获取详细资讯
	 */
	public String get(){
		System.out.println(id);
		news = new News();
		news = this.newsManager.get(id);
		ana = new Ana();
		ana = this.anaManager.get(id);
		if(ana != null){
			ActionContext.getContext().put("indivList", this.indivManager.list(ana.getId()));
			ActionContext.getContext().put("industyList", this.industryManager.list(ana.getId()));
			ActionContext.getContext().put("blockList", this.blockManager.list(ana.getId()));
		}
		return "detail";
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public INewsManager getNewsManager() {
		return newsManager;
	}
	public void setNewsManager(INewsManager newsManager) {
		this.newsManager = newsManager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public IAnaManager getAnaManager() {
		return anaManager;
	}

	public void setAnaManager(IAnaManager anaManager) {
		this.anaManager = anaManager;
	}

	public IRecordManager getRecordManager() {
		return recordManager;
	}

	public void setRecordManager(IRecordManager recordManager) {
		this.recordManager = recordManager;
	}

	public Ana getAna() {
		return ana;
	}

	public void setAna(Ana ana) {
		this.ana = ana;
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

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	
}
