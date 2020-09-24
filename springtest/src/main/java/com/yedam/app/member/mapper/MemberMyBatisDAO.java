package com.yedam.app.member.mapper;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.app.member.MemberVO;

//@Repository
public class MemberMyBatisDAO implements MemberDAO {
	// MemberMyBatis는 쿼리를 별도의 xml파일에 저장하고 불러서 씀
	
	@Autowired SqlSessionTemplate sqlSession;		// jdbc 과정을 대신해줌

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		return sqlSession.selectOne("memberDAO.selectOne",memberVO);
	}

	@Override
	public List<MemberVO> selectAll() {							// myBatis는 List로 받아와야함
		System.out.println("mybatisselectAll");
		return sqlSession.selectList("memberDAO.selectAll");	// selectList() 안에 namespace.select id 들고오면됨
	}

	@Override
	public int getMailynCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
