package spring.mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO dao;

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

	@Override
	public List<MemberDTO> memberSearchList(String item, String searchword) {
		
		
		HashMap<String, String> map = toMap(item, searchword);
		return dao.memberSearchList(map);
	}

	@Override
	public int memberCount() {
		
		return dao.totalMemberCount();
	}

	@Override
	public int memberCount(String item, String searchword) {
		
		HashMap<String, String> map = toMap(item, searchword);
		
		return dao.searchMemberCount(map);
	}
	
	
	public HashMap<String, String> toMap(String item, String searchword){
		String colName = "";
		
		if(item.equals("이름 검색")) {
			colName = "membername";
		}else if(item.equals("아이디 검색")) {
			colName = "memberid";
		}else if(item.equals("폰번호 검색")) {
			colName = "phone";
		}else if(item.equals("이메일 검색")) {
			colName = "email";
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("colname", colName);
		map.put("colvalue", searchword);
		
		return map;
	}
}
