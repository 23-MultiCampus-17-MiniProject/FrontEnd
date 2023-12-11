package spring.mybatis.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisMain {

	public static void main(String[] args) throws IOException{
		//SessionFactoryBuilder => SqlSessionFactory => SqlSession
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("spring/mybatis/service/spring-mybatis.xml");
		String names[] = beanFactory.getBeanDefinitionNames();
		
		System.out.println("====================================");
		for(String onename : names) {
			System.out.println(onename);
		}
		System.out.println("====================================");
		
		MemberService service = beanFactory.getBean("memberServiceImpl", MemberService.class);
									//어노테이션에 따로 안붙이면 클래스명에 맨앞 소문자
		
		List<MemberDTO> list = service.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto.getMemberid());
		}
		
		
		//1 회원조회
//		MemberDTO dto = service.oneMember("mybatis2");
//		System.out.println(dto.getMemberid());
		
		//조건 조회
//		List<MemberDTO> list = session.selectList("memberList2", "프");
//		for(MemberDTO dto : list) {
//			System.out.println(dto.getMemberid());
//		}
		
		//insert2
		//파라미터로 값 전달
//		MemberDTO dto = new MemberDTO();
//		dto.setMemberid("mybatis3");
//		dto.setPw("111");
//		dto.setEmail("mybatis3@edu.multi");
//		dto.setMembername("행추");
//		dto.setPhone("010-9340-2940");
//
//		String insertresult = service.registerMember(dto);
//		System.out.println(insertresult);
		
		//update
//		MemberDTO updatedto = new MemberDTO();
//		updatedto.setMemberid("mybatis3");
//		updatedto.setEmail("mybatis3update@edu.multi");
//		updatedto.setMembername("심준기");
//		updatedto.setPhone("010-2320-2344");
//		String updateResult = service.modifyMember(updatedto);
//		System.out.println(updateResult);
		
		//delete
//		String deleteResult = service.deleteMember("mybatis3");
//		System.out.println(deleteResult);
		
		//페이징 오류남 왜?
//		ArrayList<Integer> mypage = new ArrayList<Integer>();
//		mypage.add(5);
//		mypage.add(5);
//		List<MemberDTO> list = service.memberPagingList(mypage);
//		for(MemberDTO pagingdto : list) {
//			System.out.println(pagingdto.getMemberid()+ ", " + pagingdto.getMembername());
//		}
		
		//1월가입자 조회/ 이름 자바 포함 /이메일 edu 포함
		//컬럼명, 값
//		HashMap<String, String> map = new HashMap();
//		map.put("colname", "regdate");
//		map.put("colvalue", "_____01%");
//		map.put("colname", "membername");
//		map.put("colvalue", "%자바%");
//		map.put("colname", "email");
//		map.put("colvalue", "%edu%");
//		List<MemberDTO> list = service.searchList(map);
//		for(MemberDTO pagingdto : list) {
//			System.out.println(pagingdto.getMemberid()+ ", " + pagingdto.getMembername()+ "," + pagingdto.getRegdate());
//		}
		//select * from members where ${colname} like #{colvalue}
		//컬럼이름인 경우: ${} / 일반적인 값: #{}
		
//		List<MemberDTO> list = service.searchList2("firstid");
//		for(MemberDTO pagingdto : list) {
//			System.out.println(pagingdto.getMemberid()+ ", " + pagingdto.getMembername()+ "," + pagingdto.getRegdate());
//		}
		
//		List<MemberDTO> list = service.concatList();
//		for(MemberDTO pagingdto : list) {
//			System.out.println(pagingdto.getMemberid()+ ", " + pagingdto.getMembername()+ "," + pagingdto.getRegdate());
//		}
		
	}
}
