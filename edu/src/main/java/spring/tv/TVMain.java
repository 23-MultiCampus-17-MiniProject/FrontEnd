package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		//tv.xml을 읽어라
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("spring/tv/tv.xml"); //패키지명 포함 경로 알려주기"spring/tv/tv.xml"
																		//xml: 스프링과 사용자를 연결해주는 연결자
		TV tv = null;
		tv = (TV)factory.getBean("tv");//object 타입 반환 //id가 tv인 것을 읽어라
		if(tv != null) {
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		}
		
	}

}
