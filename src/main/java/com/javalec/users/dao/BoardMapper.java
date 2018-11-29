package com.javalec.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javalec.users.vo.BoardVO;

public class BoardMapper implements RowMapper<BoardVO>{
@Override
public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	BoardVO vo = new BoardVO();
	
	vo.setSeq(rs.getInt("SEQ"));
	vo.setTitle(rs.getString("TITLE"));
	vo.setWriter(rs.getString("WRITER"));
	vo.setContent(rs.getString("CONTENT"));
	vo.setRegdate(rs.getString("REGDATE"));
	vo.setCnt(rs.getInt("CNT"));
	vo.setId(rs.getString("ID"));
	
	return vo;
}
}
