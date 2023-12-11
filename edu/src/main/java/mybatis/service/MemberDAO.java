package mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	//sql실행결과 => service에리턴
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
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
}
