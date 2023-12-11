package memberservice;

public class MemberJanService implements MemberService{
	
	MemberDAO memberdao;
	PointDAO pointdao;
	public void setMemberdao(MemberDAO dao) {
		this.memberdao = dao;
	}
	
	public void setPointdao(PointDAO dao) {
		this.pointdao = dao;
	}
	@Override
	public void registerMember() {
		boolean result = memberdao.selectMember();
		if(result == false) {
			memberdao.insertMember();
			System.out.println(pointdao.getPoint() + "포인트를 획득하셨습니다.");
		}
		
	}

}
