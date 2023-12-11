package spring.mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	//sql실행결과 => service에리턴
	@Autowired
	SqlSession session; //SqlSessionTemplate이 SqlSession을 상속받았기 때문에 그대로 전달받기가능

	
	
	public List<MemberDTO> memberList(){
		return session.selectList("memberList");
	}
	
	public MemberDTO oneMember(String memberid) {
		return session.selectOne("oneMember", memberid);
	}
	public int insertMember(MemberDTO dto) {
		return session.insert("insertMemberDTO", dto);
	}
	public int updateMember(MemberDTO dto) {
		return session.update("updateMember", dto);
	}
	public int deleteMember(String memberid) {
		return session.delete("deleteMember", memberid);
	}

	public List<MemberDTO> memberPasingList(ArrayList<Integer> mypage) {
		return session.selectList("b.memberPasingList", mypage);
	}

	public List<MemberDTO> searchList(HashMap<String, String> map) {
		return session.selectList("b.searchList", map);
	}
	
	public List<MemberDTO> searchList2(String memberid) {
		return session.selectList("searchList2", memberid);
	}
	
	public List<MemberDTO> concatList() {
		return session.selectList("concatList");
	}

	public List<MemberDTO> memberSearchList(HashMap<String, String> map) {
		
		return session.selectList("b.memberSearchList", map);
	}

	public int totalMemberCount() {
		
		return session.selectOne("b.totalMemberCount");
	}

	public int searchMemberCount(HashMap<String, String> map) {
		
		return session.selectOne("b.searchMemberCount", map);
	}
}
