package annotation.spring.memberservice;

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
	public String registerMember(MemberDTO dto) {
		
		boolean result = dao.selectMember(dto);
		if(result == false) {
			dao.insertMember(dto);
			return "포인트없이 회원가입되셨습니다";
		}else {
			return "이미 가입된 회원입니다";	
		}
		
		
	}
	
}
