package com.yedam.app.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberSpringDAO implements DAO {

	@Autowired JdbcTemplate template;
	
	final static String INSERT_MEMBER="insert into member(id,pw,job,reason,gender,mailyn,hobby,regdate) values(?,?,?,?,?,?,?,sysdate)";
	final static String DELETE_MEMBER="delete from member where id=?";
	final static String SELECT_MEMBER="SELECT * FROM MEMBER WHERE ID=?";
	final static String SELECT_ALL_MEMBER="select * from member order by id";
	
	@Override
	public int insert(MemberVO memberVO) {
		Object[] args = {memberVO.getId(), memberVO.getPw(), memberVO.getJob(), memberVO.getReason(),
						 memberVO.getGender(), memberVO.getMailyn(), memberVO.getHobby()};
		template.update(INSERT_MEMBER,args);
		return template.update(INSERT_MEMBER,args);
	}
	
	@Override
	public int delete(MemberVO memberVO) {
		return template.update(DELETE_MEMBER,memberVO.getId());
	}
	
	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		Object[] args = {memberVO.getId()};		// queryForObject가 Object타입이라 배열로 만들어서 넘겨야함
		return template.queryForObject(SELECT_MEMBER, args, new MemberRowMapper());
	}

	@Override
	public List<MemberVO> selectAll() {
		return template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}

	@Override
	public int getMailynCnt() {
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		return null;
	}

	@Override
	public void update(MemberVO memberVO) {
		
	}

	class MemberRowMapper implements RowMapper<MemberVO> {

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO member = MemberVO.builder().build();
			member.setId(rs.getString("id")); // 컬럼이 첫번째 자리라서 1을 입력한거임
			member.setPw(rs.getString("pw"));
			member.setGender(rs.getString("gender")); // 컬럼명에다가 별칭있으면 별칭을 넣어줘야함
			member.setJob(rs.getString("job")); // 대소문자 구별 없음
			member.setHobby(rs.getString("hobby"));
			member.setReason(rs.getString("reason"));
			member.setMailyn(rs.getString("mailyn"));
			return member;
		}
		
	}
	
}
