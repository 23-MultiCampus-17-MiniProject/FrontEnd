package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("annotation/memberservice/member.xml");
		
		System.out.println("===포인트없이 회원가입===");
		MemberService service1 = (MemberService)factory.getBean("service1");
		service1.registerMember();
		System.out.println("===포인트 회원가입===");
		MemberService service2 = (MemberService)factory.getBean("service2");
		service2.registerMember();
		
		System.out.println("====scope테스트====");
		//<bean id = "dto1" class = "xxx.MemberDTO"/>
		// new MemberDTO(); 기본 생성자 호출 하지만 한번만 나옴
	
		
		
		System.out.println("메인끝");

	}

}
