package com.javalec.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javalec.users.dao.BoardDao;
import com.javalec.users.vo.BoardVO;

@Service("boardService")
public class BoardService implements IBoardService{
	
	@Autowired
	private BoardDao dao;
	
	
	@Override
	public List<BoardVO> getList() {
		return dao.getList();
	}
	
	@Override
	public BoardVO getBoard(int seq) {
		dao.cntplus(seq);
		return dao.getBoard(seq);
	}

	@Override
	public void write(BoardVO vo) {
		dao.write(vo);
	}
	
	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public List<BoardVO> searchTitle(String keyword) {
		return dao.searchTitle(keyword);
	}
	
	@Override
	public List<BoardVO> searchContent(String keyword) {
		return dao.searchContent(keyword);
	}
	
}
