package com.yedam.app.board;

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
	public void selectAllTest() {
		System.out.println(boardDAO.selectAll());
	}
	
	@Test
	public void InsertTest() {
		BoardVO vo = BoardVO.builder()
							.no(151)
							.subject("mybatis test")
							.contents("test")
							.poster("poster")
							.build();
		boardDAO.insert(vo);
	}
	
}
