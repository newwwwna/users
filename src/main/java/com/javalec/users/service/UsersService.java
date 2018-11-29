package com.javalec.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javalec.users.dao.UsersDao;
import com.javalec.users.vo.UsersVO;

@Service("userService")
public class UsersService implements IUsersService {

	@Autowired
	private UsersDao dao;

	@Override
	public void insert(UsersVO vo) {
		dao.insert(vo);
	}

	@Override
	public void modify(UsersVO vo) {
	 dao.modify(vo);
	}

	@Override
	public List<UsersVO> getList() {
		return dao.getList();
	}


	@Override
	public UsersVO getUsers(UsersVO vo) {
		
		return dao.getUsers(vo);
	}

}
