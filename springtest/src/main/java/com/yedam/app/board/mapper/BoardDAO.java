package com.yedam.app.board.mapper;

import java.util.HashMap;
import java.util.List;

import com.yedam.app.board.BoardVO;

public interface BoardDAO { 

	// 단건 조회
	BoardVO selectOne(BoardVO boardVO);

	// 전체 조회
	List<BoardVO> selectAll();

	// 메일 수신 회원수
	int getMailynCnt();

	// 성별 인원수
	List<HashMap<String, Object>> getGenderCnt();

	// update
	int update(BoardVO boardVO);

	// delete
	int delete(BoardVO boardVO);

	// insert
	public void insert(BoardVO boardVO);

}