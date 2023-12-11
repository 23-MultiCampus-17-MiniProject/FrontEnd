package member;

public class MemberDAO {
	MemberDTO dto; //스프링 특징 객체를 직접 만들지말고 스프링받아오자 
				   //자바클래스들끼리 객체 전달 - 매개변수(메서드나 생성자)
	
	public void setDto(MemberDTO dto){
		this.dto = dto;
	}
	
	public boolean selectMember() {
		
		if(dto.getMemberid().equals("spring") && dto.getPw().equals("1234")) {
			System.out.println(dto.getMemberid());
			return true;
		}else {
			System.out.println(dto.getMemberid());
			return false;
		}
	}
	
	public void insertMember() {
		System.out.println(dto.getMemberid() + "회원님 정상적으로 회원가입되었습니다");
	}
	
}
