package annotation.spring.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("memberdao")
public class MemberDAO {

	public boolean selectMember(MemberDTO dto) {
		
		if(dto.getMemberid().equals("spring") && dto.getPw().equals("1234")) {
			System.out.println(dto.getMemberid());
			return true;
		}else {
			System.out.println(dto.getMemberid());
			return false;
		}
	}
	
	public void insertMember(MemberDTO dto) {
		System.out.println(dto.getMemberid() + "회원님 정상적으로 회원가입되었습니다");
	}
	
}
