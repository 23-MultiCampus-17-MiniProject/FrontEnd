package annotation.spring.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service2")
public class MemberJanService implements MemberService{

	@Autowired
	MemberDAO memberdao;
	@Autowired
	PointDAO pointdao;
	
	@Override
	public String registerMember(MemberDTO dto) {
		boolean result = memberdao.selectMember(dto);
		if(result == false) {
			memberdao.insertMember(dto);
			pointdao.setPoint(10000);
			System.out.println(pointdao.getPoint() + "포인트를 획득하셨습니다.");
			return pointdao.getPoint() + "포인트를 획득하고 회원가입되셨습니다";
		}
		else {
			return "이미 가입된 회원입니다";
		}
	}

}
