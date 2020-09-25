package com.yedam.app.board;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/*-context.xml"})

public class BoardDAOClient {
	
	@Autowired BoardDAO boardDAO;
	
	
	
	//@Test
	public void cntTest() {
		System.out.println(boardDAO.selectCnt());
	}
	
	
	// map으로 select
	//@Test
	public void selectMapTest() {
		System.out.println(boardDAO.selectMap());
	}
	
	
	//@Test
	public void deleteAllTest() {
		List<String> list = Arrays.asList(new String[]{"1","3","5","7"});
		BoardVO vo = BoardVO.builder()
							.nos(list)
							.build();
		boardDAO.deleteAll(vo);
	}
	
	
	@Test
	public void selectAllTest() {
		BoardVO vo = BoardVO.builder()
							//.poster("2")
							//.boardSubject("ㅇㅇ")
							.first(5)
							.last(10)
							.build();
		List<BoardVO> list = boardDAO.selectAll(vo);
		for(BoardVO board : list) {
			System.out.println(board.getBoardNo() + ":" + board.getBoardSubject() + ":" + 
							   board.getPoster() + ":" + board.getLastpost());
		}
	}
	
	//@Test
	public void InsertTest() {
		BoardVO vo = BoardVO.builder()
							.boardSubject("mybatis test")
							.contents("test")
							.poster("poster")
							.build();
		boardDAO.insert(vo);
		System.out.println("no값 확인:"+vo.getBoardNo());
	}
	
}
