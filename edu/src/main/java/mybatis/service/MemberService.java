package mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface MemberService {
	
	public List<MemberDTO> memberList();
	MemberDTO oneMember(String memberid);
	String registerMember(MemberDTO dto);
	String modifyMember(MemberDTO dto);
	String deleteMember(String memberid);
	public List<MemberDTO> memberPagingList(ArrayList<Integer> mypage);
	public List<MemberDTO> searchList(HashMap<String, String> map);
	public List<MemberDTO> searchList2(String memberid);
	public List<MemberDTO> concatList();
}
