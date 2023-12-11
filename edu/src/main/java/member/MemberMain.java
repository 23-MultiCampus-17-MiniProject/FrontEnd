package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("member/member.xml");
		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		boolean loginresult = dao.selectMember();
		System.out.println("로그인 결과= " + loginresult);

	}

}
