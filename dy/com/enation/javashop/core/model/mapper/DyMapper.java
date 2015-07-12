package com.enation.javashop.core.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.enation.javashop.core.model.Dy;

/*
 * lzc
 * 2015年1月6日17:02:19
 */
public class DyMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs1, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Dy dy = new Dy();
		dy.setDy_id(rs1.getString("dy_id"));
		dy.setDy_name(rs1.getString("dy_name"));
		dy.setDy_content(rs1.getString("dy_content"));
		dy.setDy_createtime(rs1.getDate("dy_createtime"));
		dy.setUser_id(rs1.getString("user_id"));
		dy.setUser_name(rs1.getString("user_name"));
		dy.setDy_finaltime(rs1.getDate("dy_finaltime"));
		dy.setDy_delete(rs1.getInt("dy_delete"));
		dy.setDy_state(rs1.getInt("dy_state"));
		dy.setDy_look(rs1.getShort("dy_look"));
		dy.setDy_choose(rs1.getInt("dy_choose"));
		dy.setDy_choosey(rs1.getInt("dy_choosey"));
		dy.setDy_choosen(rs1.getInt("dy_choosen"));
		dy.setDy_picture(rs1.getString("dy_picture"));
		dy.setDy_open(rs1.getInt("dy_open"));
		dy.setDy_check(rs1.getInt("dy_check"));
		dy.setDy_frozen(rs1.getInt("dy_frozen"));
		dy.setDy_past(rs1.getInt("dy_past"));
		return dy;
	}

}
