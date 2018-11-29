package com.javalec.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javalec.users.vo.UsersVO;

public class UsersMapper implements RowMapper<UsersVO> {
	
public UsersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UsersVO vo = new UsersVO();
		
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("NAME"));
		vo.setPassword(rs.getString("PASSWORD"));
		vo.setRole(rs.getString("ROLE"));
		
		return vo;
	}
}
