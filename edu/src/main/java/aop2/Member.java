package aop2;

import org.springframework.stereotype.Component;

@Component
public class Member {

	void login(String id) {
		System.out.println(id + "회원님 로그인하셨습니다");
	}
	
	void logout() {
		System.out.println("로그아웃하셨습니다");
	}
}
