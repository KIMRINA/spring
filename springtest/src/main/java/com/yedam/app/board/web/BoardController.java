package com.yedam.app.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yedam.app.board.service.BoardService;


//@Controller
public class BoardController {
	
	//@Autowired		// getBean("memberDAO")
					// new MemberDAO() <-필요없이 필요한 객체가 있으면 들고와서 씀
	BoardService boardService;
	
	
	
}
