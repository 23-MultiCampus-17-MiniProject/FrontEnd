package aop2;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop2/aop2.xml");
//		Member member = (Member)factory.getBean("member");
		Member member = factory.getBean("member", Member.class); //형변환 안해도 되게
		member.login("aoptest");
		
//		Board board = (Board)factory.getBean("board");
		Board board = factory.getBean("board", Board.class); //형변환 안해도 되게
		ArrayList<String> list = board.getList();
		board.insert(6);
		member.logout();
	}

}
