package com.enation.core.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.enation.core.model.Ana;
import com.enation.core.model.News;

public class NewsMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		News news = new News();
		Ana ana = new Ana();
		ana.setId(rs.getString("id"));
		ana.setNewsid(rs.getInt("newsid"));
		ana.setContent(rs.getString("content"));
		ana.setPurp(rs.getFloat("purp"));
		ana.setInfluence(rs.getFloat("influence"));
		ana.setWeigh(rs.getFloat("weigh"));
		ana.setSrt(rs.getFloat("srt"));
		ana.setMeta(rs.getFloat("meta"));
		ana.setLon(rs.getFloat("lon"));
		ana.setUserid(rs.getInt("userid"));
		ana.setName(rs.getString("name"));
		ana.setTime(rs.getLong("time"));
		ana.setDel(rs.getByte("del"));
		news.setAna(ana);
		news.setId(rs.getInt("id"));
		news.setName(rs.getString("name"));
		news.setLev(rs.getString("lev"));
		news.setOne(rs.getString("one"));
		news.setTwo(rs.getString("two"));
		news.setThree(rs.getString("three"));
		news.setUserid(rs.getInt("userid"));
		news.setUsername(rs.getString("username"));
		news.setWay(rs.getString("way"));
		news.setTime(rs.getLong("time"));
		news.setChain(rs.getString("chain"));
		news.setAbs(rs.getString("abs"));
		news.setContent(rs.getString("content"));
		news.setCompare(rs.getString("compare"));
		news.setOrg(rs.getString("org"));
		news.setMedia(rs.getString("media"));
		news.setDel(rs.getByte("del"));
		return news;
	}
	

}
