package com.yedam.app.member.service;

import java.util.List;
import java.util.Map;

import com.yedam.app.member.MemberVO;

public interface MemberService {
	// 조회
	List<Map<String, Object>> selectAllmap();

	// 단건 조회
	MemberVO selectOne(MemberVO memberVO);

	// 전체 조회
	List<MemberVO> selectAll();

	// update
	int update(MemberVO memberVO);

	// delete
	int delete(MemberVO memberVO);

	// insert
	int insert(MemberVO memberVO);

}