package com.javalec.users.service;

import java.util.List;

import com.javalec.users.vo.BoardVO;

public interface IBoardService {
	public void write(BoardVO vo);

	public List<BoardVO> getList();

	public void update(BoardVO vo);

	public void delete(BoardVO vo);

	public BoardVO getBoard(int seq);
	
	public List<BoardVO> searchTitle(String keyword);
	
	
	public List<BoardVO> searchContent(String keyword);
}
