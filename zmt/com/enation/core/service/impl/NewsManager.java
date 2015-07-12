package com.enation.core.service.impl;

import java.util.List;

import com.enation.core.model.News;
import com.enation.core.model.mapper.NewsMapper;
import com.enation.core.service.INewsManager;
import com.enation.eop.sdk.database.BaseSupport;
import com.enation.util.StringUtil;

public class NewsManager extends BaseSupport<News> implements INewsManager{

	@Override
	public List<News> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		/*
		 * newsmapper还未理好
		 */
		return this.baseDaoSupport.queryForList("select * from news left join ana on es_news.id = es_ana.newsid ", pageNo, pageSize, new NewsMapper());
//		return this.baseDaoSupport.queryForList("select * from news", News.class);
	}
	
	@Override
	public List<News> list(int pageNo, int pageSize, News news, Long begin, Long end) {
		// TODO Auto-generated method stub
		
		news.setLev(StringUtil.changePercent(news.getLev()));
		news.setOne(StringUtil.changePercent(news.getOne()));
		news.setTwo(StringUtil.changePercent(news.getTwo()));
		news.setThree(StringUtil.changePercent(news.getThree()));
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("select * from news where lev like '" + news.getLev() + "' and one like  '" + news.getOne() +
				"' and two like '" + news.getTwo() + "' and three like '" + news.getThree() + "'");
		if(begin != 0){
			sBuffer.append(" and time >= '" + begin + "'");
		}
		if(end != 0){
			sBuffer.append(" and time <= '" + end + "'");
			
		}
		if(!StringUtil.isEmpty(news.getWay())){
			sBuffer.append(" and way lile '" + StringUtil.addPercent(news.getContent()) + "'");
		}
		if(!StringUtil.isEmpty(news.getUsername())){
			sBuffer.append(" and content like '" + StringUtil.addPercent(news.getUsername()) + "'");
		}
		if(!StringUtil.isEmpty(news.getContent())){
			sBuffer.append(" and content like '" + StringUtil.addPercent(news.getContent()) + "'");
		}
//		String sql = "select * from news where lev like '" + news.getLev() + "' and one like  '" + news.getOne() +
//				"' and two like '" + news.getTwo() + "' and three like '" + news.getThree() + "' and time >= '" + begin + "' and time <= '" + end + "' and way like  '" +  news.getWay() +
//				"' and username like '" +  news.getUsername() + "' and content like '" + StringUtil.addPercent(news.getContent()) +"' ";
		System.out.println(sBuffer.toString());
		return this.baseDaoSupport.queryForList(sBuffer.toString(), News.class );
	}

	@Override
	public void add(News news) {
		// TODO Auto-generated method stub
		this.baseDaoSupport.insert("news", news);
	}

	@Override
	public News get(int id) {
		// TODO Auto-generated method stub
		return this.baseDaoSupport.queryForObject("select * from news where id = ? ", News.class, id);
	}
}
