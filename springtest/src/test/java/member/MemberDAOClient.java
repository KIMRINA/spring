package member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.DAO;
import com.yedam.app.member.MemberDAO;
import com.yedam.app.member.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:config/datasource-context.xml"})
public class MemberDAOClient {

		@Autowired DAO dao;
		
		@Test
		@Ignore
		public void SelectTest() {
			MemberVO memberVO = MemberVO.builder().id("ccc").build();	// 생성자를 대신해주는게 builder
			memberVO = dao.selectOne(memberVO);
			assertEquals("1111", memberVO.getPw());	// memberVO의 pw와 밑에 넣어논 1111가 같은지 비교해줌
		}
		
		@Test
		@Ignore
		public void selectAllTest() {
			List<MemberVO> list = dao.selectAll();		// dao.selectAll();만 적어도 실행가능
		}
		
		@Test
		//@Ignore		// Ignore는 test를 무시하는것
		public void insertTest() {
			MemberVO memberVO = MemberVO.builder().id("dddd").pw("1111")
												  .hobby("music").reason("...")
												  .build();	// 생성자를 대신해주는게 builder
			dao.insert(memberVO);
			//memberVO = dao.selectOne(memberVO);
			//assertNotNull(memberVO);
		}
		
		@Test
		@Ignore
		public void deleteTest() {
			MemberVO memberVO = MemberVO.builder().id("hhhh").build();
			dao.delete(memberVO);
		}
		
}
