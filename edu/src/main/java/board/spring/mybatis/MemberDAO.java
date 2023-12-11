package board.spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	public MemberDTO oneMember(String memberid) {
		MemberDTO dto = session.selectOne("oneMember" , memberid);
		return dto;
	}

}
