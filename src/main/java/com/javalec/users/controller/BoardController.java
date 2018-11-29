package com.javalec.users.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.users.vo.BoardVO;
import com.javalec.users.service.IBoardService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private IBoardService boardService;
	
	@RequestMapping("/list.do")
	public String list(BoardVO vo, Model model, HttpServletRequest req) {
	
		List<BoardVO> list = null;
		
		String keyword = req.getParameter("keyword");
		String search = req.getParameter("search");
		if(keyword !=null) {
			if(search.equals("content"))
			{
				list = boardService.searchContent(keyword);
			} else {
				list = boardService.searchTitle(keyword);
			}
		} else if (keyword==null || keyword.isEmpty()) {
			list = boardService.getList();
			
		}
		
		model.addAttribute("list", list);
		return "getBoardList.jsp";
	}
	

	
	@RequestMapping("/insert.do")
	public String insert(BoardVO vo) {
		boardService.write(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("/getboard.do")
	public String selectone(Model model,  @RequestParam(value="seq") String seq) {
		//String seq = request.getParameter("seq");
		
		if(seq==null || seq.isEmpty()) {
			return "redirect:list.do";
		}
		int no = Integer.parseInt(seq);
		
		BoardVO board = boardService.getBoard(no);
		
		model.addAttribute("board", board);
		return "getBoard.jsp";
		
	}
	
	@RequestMapping("/modify.do")
	public String modify(BoardVO vo, Model model) {
		
		boardService.update(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("/modifyForm.do")
	public String modifyForm(BoardVO vo, Model model, @RequestParam(value="seq") String seq) {
		if(seq==null || seq.isEmpty()) {
			return "redirect:list.do";
		} 
		int no = Integer.parseInt(seq);
		BoardVO board = boardService.getBoard(no);
		model.addAttribute("board", board);
		return "modifyBoard.jsp";
	}
	
	@RequestMapping("/delete.do")
	public String delete(BoardVO vo, @RequestParam(value="seq") String seq) {
		if(seq==null || seq.isEmpty()) {
			return "redirect:list.do";
		} 
		int no = Integer.parseInt(seq);
		vo.setSeq(no);
		boardService.delete(vo);
		return "redirect:list.do";
	}
	
	
	
}
