package com.yedam.app.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.app.board.BoardVO;

//@Repository
public class BoardMyBatisDAO implements BoardDAO {
	// MemberMyBatis는 쿼리를 별도의 xml파일에 저장하고 불러서 씀
	
	@Autowired SqlSessionTemplate sqlSession;		// jdbc 과정을 대신해줌

	@Override
	public BoardVO selectOne(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void insert(BoardVO boardVO) {
		// TODO Auto-generated method stub
	}
	
}
