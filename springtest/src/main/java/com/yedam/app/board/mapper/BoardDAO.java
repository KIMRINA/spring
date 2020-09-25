package com.yedam.app.board.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.app.board.BoardVO;

public interface BoardDAO { 

	// 단건 조회
	BoardVO selectOne(BoardVO boardVO);

	// 전체 조회
	List<BoardVO> selectAll(BoardVO boardVO);
	
	// 삭제
	public void deleteAll(BoardVO boardVO);
	
	// selectMap
	public List<Map<String,Object>> selectMap();
	
	// selectCnt
	public int selectCnt();
	

	// update
	int update(BoardVO boardVO);

	// insert
	public void insert(BoardVO boardVO);

}