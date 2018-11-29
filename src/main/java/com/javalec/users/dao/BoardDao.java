package com.javalec.users.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javalec.users.vo.BoardVO;
import com.javalec.users.vo.UsersVO;
import com.javalec.users.dao.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	String sql_insert="INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, sysdate,?,?)";
	String sql_list = "SELECT SEQ, TITLE, WRITER, CONTENT, REGDATE, CNT, ID FROM BOARD ORDER BY REGDATE DESC";
	String sql_update = "UPDATE BOARD SET TITLE=?, WRITER=?, CONTENT=?, REGDATE=SYSDATE WHERE SEQ=?";
	String sql_delete = "DELETE FROM BOARD WHERE SEQ=?";
	String sql_searchTitle = "SELECT SEQ, TITLE, WRITER, CONTENT, REGDATE, CNT, ID FROM BOARD WHERE TITLE LIKE ? ORDER BY REGDATE DESC";
	String sql_searchContent = "SELECT SEQ, TITLE, WRITER, CONTENT, REGDATE, CNT, ID FROM BOARD WHERE CONTENT LIKE ? ORDER BY REGDATE DESC";
	String sql_searchone = "SELECT SEQ, TITLE, WRITER, CONTENT, REGDATE, CNT, ID FROM BOARD WHERE SEQ=?";
	String sql_cntplus = "UPDATE BOARD SET CNT=CNT+1 WHERE SEQ=?";
	
	public int write(BoardVO vo) {
	
		Object args[]= {vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getCnt(), vo.getId()};
		return jdbcTemplate.update(sql_insert, args);
	}
	
	
	public List<BoardVO> getList() {
		return jdbcTemplate.query(sql_list, new BoardMapper()); 

	}

	public int update(BoardVO vo) {
		Object args[] = {vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq()};
		return jdbcTemplate.update(sql_update, args);
	}

	public int cntplus(int seq) {
		Object args[] = {seq};
		return jdbcTemplate.update(sql_cntplus, args);
	}

	public int delete(BoardVO vo) {
		Object args[] = {vo.getSeq()};
		return jdbcTemplate.update(sql_delete, args);
	}

	public List<BoardVO> searchTitle(String keyword) {
		Object args[] = {"%"+keyword+"%" };
		return jdbcTemplate.query(sql_searchTitle, args, new BoardMapper());
			
	}
	
	public List<BoardVO> searchContent(String keyword) {
		Object args[] = {"%"+keyword+"%" };
		return jdbcTemplate.query(sql_searchContent, args, new BoardMapper());
			
	}
	
	public BoardVO getBoard(int seq) {
		Object args[] = {seq};

		return jdbcTemplate.queryForObject(sql_searchone, args, new BoardMapper());
	
}
}
