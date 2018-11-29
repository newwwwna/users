package com.javalec.users.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.javalec.users.vo.UsersVO;


@Repository
public class UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	String sql_insert="INSERT INTO USERS VALUES(?,?,?,?)";
	String sql_selectone = "SELECT ID, PASSWORD, NAME, ROLE FROM USERS WHERE ID=?";
	String sql_list = "SELECT ID, PASSWORD, NAME, ROLE FROM USERS";
	String sql_modify = "UPDATE USERS SET PASSWORD=?, NAME=?, ROLE=? WHERE ID=?";
	
	public int insert(UsersVO vo) {
		Object args[] = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		return  jdbcTemplate.update(sql_insert,args);
	}
	
	public int modify(UsersVO vo) {
		Object args[] = {vo.getPassword(), vo.getName(), vo.getRole(), vo.getId()};
		return  jdbcTemplate.update(sql_modify,args);
	}
	
	
	public UsersVO getUsers(UsersVO vo) {
			Object args[] = {vo.getId()};
	
			return jdbcTemplate.queryForObject(sql_selectone, args, new UsersMapper());
		
	}
	
	public List<UsersVO> getList() {
		return jdbcTemplate.query(sql_list, new UsersMapper());
		
	
		
	}
	

}

