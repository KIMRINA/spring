package com.yedam.app.member.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDAO memberDAO;
	
	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		return memberDAO.selectOne(memberVO);
	}

	@Override
	public List<MemberVO> selectAll() {
		return memberDAO.selectAll();
	}

	@Override
	public int update(MemberVO memberVO) {
		return memberDAO.update(memberVO);
	}

	@Override
	public int delete(MemberVO memberVO) {
		return memberDAO.delete(memberVO);
	}

	@Override
	public int insert(MemberVO memberVO) {
		return memberDAO.insert(memberVO);
	}

}
