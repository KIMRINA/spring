package com.yedam.app.member;

import java.util.HashMap;
import java.util.List;

public interface DAO {

	// 단건 조회
	MemberVO selectOne(MemberVO memberVO);

	// 전체 조회
	List<MemberVO> selectAll();

	// 메일 수신 회원수
	int getMailynCnt();

	// 성별 인원수
	List<HashMap<String, Object>> getGenderCnt();

	// update
	void update(MemberVO memberVO);

	// delete
	int delete(MemberVO memberVO);

	// insert
	int insert(MemberVO memberVO);

}