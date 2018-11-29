package com.javalec.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.users.dao.UsersDao;
import com.javalec.users.service.IUsersService;
import com.javalec.users.vo.UsersVO;

@Controller("userController")
public class UsersController {

	@Autowired
	@Qualifier("userService")
	private IUsersService userService;

	@RequestMapping("/joinform.do")
	public String insertUsers() {
		return "joinform.jsp";
	}

	@RequestMapping("/join.do")
	public String insertformUsers(UsersVO vo) {
		userService.insert(vo);
		return "login.jsp";
	}
	
	@RequestMapping("/usermodify.do")
	public String usermodify(UsersVO vo) {
		userService.modify(vo);
		return "login.jsp";
	}
	
	@RequestMapping("/usermodifyform.do")
	public String usermodifyform(UsersVO vo) {
		
		return "login.jsp";
	}

	@RequestMapping("/login.do")
	public String loginUsers(UsersVO vo, HttpSession session, HttpServletRequest req) {
				
		if(userService.getUsers(vo)!=null) {
			UsersVO vo2 = userService.getUsers(vo);
			if(vo2.getPassword().equals(vo.getPassword())){
				session.setAttribute("id", vo.getId());
				session.setAttribute("password", vo.getPassword());
				return "redirect:list.do";
			} else {
				session.setAttribute("error", "아이디/비밀번호를 확인하세요!");
				return "login.jsp";
			} 
		} else {
			session.setAttribute("error", "아이디가 존재하지 않습니다.");
			return "redirect:list.do";
		}
}


	@RequestMapping("/search.do")
	public String search(HttpServletRequest req) {

		return "findpassword.jsp";
	}

	@RequestMapping("/searchpw.do")
	public String searchpw(UsersVO vo, @RequestParam(value="id") String id, Model model) {
		
		if(userService.getUsers(vo)!=null) {
		vo = userService.getUsers(vo);
		model.addAttribute("password", vo.getPassword());
		return "findpassword.jsp";
		} else {
			model.addAttribute("error", "아이디가 존재하지 않습니다.");
			return "findpassword.jsp";
		}
		
	}

	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}
}
