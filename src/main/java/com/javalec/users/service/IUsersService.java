package com.javalec.users.service;

import java.util.List;

import com.javalec.users.vo.UsersVO;

public interface IUsersService {
	public void insert(UsersVO vo);
	public void modify(UsersVO vo);
	public List<UsersVO> getList();
	public UsersVO getUsers(UsersVO vo);
	
}
