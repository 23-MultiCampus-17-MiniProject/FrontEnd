package unesu;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("unesu/figure.xml");
		Scanner sc = new Scanner(System.in);
		Digestion digestion = (Digestion)factory.getBean("digestion");
		
		System.out.print("이름을 입력해주세요: ");
		String name = sc.nextLine();
		digestion.cycle(name);

	}

}
