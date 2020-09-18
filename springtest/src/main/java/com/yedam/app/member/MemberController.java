package com.yedam.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired		// getBean("memberDAO")
					// new MemberDAO() <-필요없이 필요한 객체가 있으면 들고와서 씀
	DAO dao;
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {				// web-inf는 외부에서 접근불가해서 프로젝트에서 실행해야함
		// 회원조회
		model.addAttribute("list",dao.selectAll());		// MemberDAO dao = new MemberDAO(); 가 필요없음
		
		return "/member/memberAll";					// 컨트롤러가 리턴으로 와서 리턴페이지로 넘어갈거임
	}
	
	// 등록처리
	@RequestMapping("/memberInsert")
	public String memberInsert(MemberVO vo) {
		System.out.println(vo);
		return "/member/memberList";
	}
}
