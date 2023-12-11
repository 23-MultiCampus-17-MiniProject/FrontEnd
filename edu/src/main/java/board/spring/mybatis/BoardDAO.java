package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession session;
	
	public int insertBoardDTO(BoardDTO dto) {
		return session.insert("insertBoardDTO" ,dto);
	}

	public List<BoardDTO> pagingBoardlist(HashMap<String, Integer> map) {
		return session.selectList("selectPasingBoardlist", map);
	}
	
	int getTotalBoard() {
		return session.selectOne("getTotalBoard");
	}

	public void increViewcount(int seq) {
		
		int test = session.update("increViewcount", seq);
		System.out.println("업데이트 쿼리 작동 확인" + test);
	}

	public BoardDTO selectOneBoard(int seq) {

		return session.selectOne("selectOneBoard", seq);
	}

	public void deleteBoard(int seq) {
		
		session.delete("deleteBoard", seq);
	}

	public void updateBoard(BoardDTO dto) {
		
		session.update("updateBoard", dto);
	}
	

}
