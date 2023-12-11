package memberservice;

public class MemberBasicService implements MemberService {
	
	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
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
