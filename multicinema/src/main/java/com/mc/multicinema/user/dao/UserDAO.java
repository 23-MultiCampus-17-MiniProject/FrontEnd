package com.mc.multicinema.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.multicinema.user.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSession session;
	
	public UserDTO loginProcess(String user_id, String user_pw) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		System.out.println("=========="+user_id+"/"+user_pw+"/"+map.get("user_id")+"/"+map.get("user_pw")+"==========");
		return session.selectOne("login", map);
		
	}

	public List<UserDTO> memberCheckProcess(String user_id, String user_email) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_email", user_email);
		
		return session.selectList("selectMemberCheck", map);
	}

	public int memberJoinProcess(UserDTO dto) {
		
		return session.insert("memberInsert", dto);
	}

	public List<UserDTO> selectList() {
		return session.selectList("user.selectUserAll");
	}

	public UserDTO selectUserOne(int user_key) {
		return session.selectOne("user.selectUserOne", user_key);
	}
}
