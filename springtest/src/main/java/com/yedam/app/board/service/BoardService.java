package com.yedam.app.board.service;

import java.util.List;

import com.yedam.app.board.BoardVO;

public interface BoardService {

	// 단건 조회
	BoardVO selectOne(BoardVO boardVO);

	// 전체 조회
	List<BoardVO> selectAll();

	// update
	int update(BoardVO boardVO);

	// delete
	int delete(BoardVO boardVO);

	// insert
	int insert(BoardVO boardVO);

}