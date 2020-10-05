package com.yedam.app.member.web;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired		// getBean("memberDAO")
					// new MemberDAO() <-필요없이 필요한 객체가 있으면 들고와서 씀
	MemberService memberService;
	
	// 아작스 단건조회
	@RequestMapping("/memberSelectOneAjax")
	@ResponseBody
	public MemberVO memberSelectOneAjax(MemberVO memberVO) {
		return memberService.selectOne(memberVO);
	}
	
	// 아작스 전체조회
	@RequestMapping("/memberListAjax")
	@ResponseBody		// json string 변환
	public List<MemberVO> memberListAjax() {
		// 회원조회
		return memberService.selectAll();		// 리턴되는 결과값을 ajax로 변환시켜줌
	}
	
	@RequestMapping("/memberList")
	public String memberList(Model model, HttpServletRequest request, HttpSession session) {	// web-inf는 외부에서 접근불가해서 프로젝트에서 실행해야함
		// 회원조회
		model.addAttribute("list",memberService.selectAll());		// MemberDAO dao = new MemberDAO(); 가 필요없음
		return "member/memberAll";									// 컨트롤러가 리턴으로 와서 리턴페이지로 넘어갈거임
	}
	
	// 등록페이지
	@RequestMapping(value = "/memberInsert", method=RequestMethod.GET)
	public String memberInsertForm() {
		return "member/memberInsert";
	}
	
	
	// 등록처리
	@RequestMapping(value = "/memberInsert", method=RequestMethod.POST )
	public String memberInsert(MemberVO memberVO) {
		memberService.insert(memberVO);
		return "redirect:/memberList";
	}
	
	// 단건조회
	@RequestMapping(value="/memberSelect")
	// @RequestParam(name = "id")는 파라미터값으로 넘어올 이름 설정,
	// required = false는 null도 가능하도록 파라미터값(id) 필수로 안넘어와도 된다고 설정한거
	// defaultValue = "user1" 는 디폴트값 넣은거
	public String memberSelect(@RequestParam(name = "id", required = false, defaultValue = "user1") 
								String mid, Model model,
								HttpServletRequest request) {	// 모델이 request.setAttribute와 같음
		// String mid = request.getParameter("id");				// @RequestParam(name = "id") String id과 같음
		// if(mid == null) {									// defaultValue = "user1"와 같음
		//	  mid = "user1";
		// }
		MemberVO vo = new MemberVO();
		vo.setId(mid);
		model.addAttribute("member",memberService.selectOne(vo));
		return "member/memberSelect";
		
	}
	
	// 경로명에 변수가 포함(@PathVariable)
	@RequestMapping("/userSelectPath/{id}")	// 경로 뒤에 들어오는 {}값은 파라미터 변수값. 이것을 읽어오려면 @PathVariable 사용
	// @PathVariable String id는 파라미터 경로명을 슬래쉬뒤에 사용할 수 있게 해줌
	public String userSelectPath(Model model, @PathVariable String id) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		model.addAttribute("member",memberService.selectOne(vo));
		return "member/memberSelect"; 
	}
	
	
	// 파라미터를 map에 포함()
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		return "";
	}
	
	
}
