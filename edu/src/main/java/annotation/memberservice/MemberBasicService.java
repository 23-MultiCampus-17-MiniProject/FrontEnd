package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
//<bean id="service1" class = "...MemberBasicService">
public class MemberBasicService implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
//	public void setDao(MemberDAO dao) {
//		this.dao = dao;
//	}
	
	@Override
	public void registerMember() {
		
		boolean result = dao.selectMember();
		if(result == false) {
			dao.insertMember();
		}else {
			System.out.println("이미 가입된 회원입니다");	
		}

	}
	
}
