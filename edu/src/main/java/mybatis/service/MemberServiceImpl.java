package mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberServiceImpl implements MemberService{
	
	MemberDAO dao;
	
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<MemberDTO> memberList() {
		return dao.memberList();
		
	}

	@Override
	public MemberDTO oneMember(String memberid) {
		
		return dao.oneMember(memberid);
	}

	@Override
	public String registerMember(MemberDTO dto) {
		MemberDTO selectDto = dao.oneMember(dto.getMemberid());
		if(selectDto != null) {
			return "아이디 중복 -회원 가입 불가능합니다";
		}else {
			dao.insertMember(dto);
			return "정상적으로 회원 가입 되었습니다";
		}
		
	}

	@Override
	public String modifyMember(MemberDTO dto) {
		MemberDTO selectdto = dao.oneMember(dto.getMemberid());
		if(selectdto == null) {
			return "해당 회원은 존재하지 않습니다";
		}else {
			dao.updateMember(dto);
			return "정상적으로 회원정보 수정했습니다";
		}
	}

	@Override
	public String deleteMember(String memberid) {
		MemberDTO selectdto = dao.oneMember(memberid);
		if(selectdto == null) {
			return "해당 회원은 존재하지 않습니다";
		}else {
			dao.deleteMember(memberid);
			return "정상적으로 회원정보 삭제했습니다";
		}
	}

	public List<MemberDTO> memberPagingList(ArrayList<Integer> mypage) {
		
		return dao.memberPasingList(mypage);
	}

	public List<MemberDTO> searchList(HashMap<String, String> map) {
		
		return dao.searchList(map);
	}
	
	public List<MemberDTO> searchList2(String memberid){
		return dao.searchList2(memberid);
	}

	@Override
	public List<MemberDTO> concatList() {
		
		return dao.concatList();
	}

}
