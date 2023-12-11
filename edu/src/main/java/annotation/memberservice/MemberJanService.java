package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service2")
public class MemberJanService implements MemberService{

	@Autowired
	MemberDAO memberdao;
	@Autowired
	PointDAO pointdao;
	
//	public void setMemberdao(MemberDAO dao) {
//		this.memberdao = dao;
//	}
//	
//	public void setPointdao(PointDAO dao) {
//		this.pointdao = dao;
//	}
	
	@Override
	public void registerMember() {
		boolean result = memberdao.selectMember();
		if(result == false) {
			memberdao.insertMember();
			System.out.println(pointdao.getPoint() + "포인트를 획득하셨습니다.");
		}
		
	}

}
