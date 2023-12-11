package mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {

	public static void main(String[] args) throws IOException{
		//SessionFactoryBuilder => SqlSessionFactory => SqlSession
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); //mybatis 설정 xml 파일 읽어오기 위함
		
		SqlSessionFactory factory = 
				builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		
		SqlSession session = factory.openSession(true);
		//sqlsession = jdbc connection 객체
		//openSession(), openSession(false) commit/rollback 수동결정
		//openSession(true) commit/rollback 자동결정
		
		//memberList id sql 실행 결과 mybatis.MemberDTO 객체 매핑
//		List<MemberDTO> list = session.selectList("a.memberList");
//		for(MemberDTO dto : list) {
//			System.out.println(dto.getMemberid());
//		}
		
		//1 회원조회
		//session.selectOne(): 딱하나만 읽어오는 것 sql도 결과가 하나만 나오게 짜야함
		//session.selectOne(sql id, 파라미터)
//		MemberDTO dto = session.selectOne("oneMember", "spring");
//		System.out.println("아이디: " + dto.getMemberid() + " 이름: " +dto.getMembername());
		
		//조건 조회
//		List<MemberDTO> list = session.selectList("memberList2", "프");
//		for(MemberDTO dto : list) {
//			System.out.println(dto.getMemberid());
//		}
		
		//insert1
		//정적으로 추가
//		int insertrow = session.insert("insertMember");
//		System.out.println(insertrow + "행이 추가되었습니다");
//		session.commit();
		
		//insert2
		//파라미터로 값 전달
//		MemberDTO dto = new MemberDTO();
//		dto.setMemberid("mybatis3");
//		dto.setPw("111");
//		dto.setEmail("mybatis3@edu.multi");
//		dto.setMembername("행추");
//		dto.setPhone("010-9340-2940");
//		
//		int insertrow = session.insert("insertMemberDTO", dto);
//		System.out.println(insertrow + "행이 추가되었습니다");
		//update
		MemberDTO updatedto = new MemberDTO();
		updatedto.setMemberid("mybatis3");
		updatedto.setEmail("mybatis3update@edu.multi");
		updatedto.setMembername("심준기");
		updatedto.setPhone("010-2320-2344");
		int updaterow = session.update("updateMember", updatedto);
		System.out.println(updaterow + "행이 수정되었습니다");
		//delete
		int deleterow = session.delete("deleteMember", "mybatis3");
		System.out.println(deleterow + "행이 삭제되었습니다");
		
		
		
		
	
	}
}
