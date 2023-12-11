package com.mc.multicinema.user.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.multicinema.user.dao.UserDAO;
import com.mc.multicinema.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userdao;
	
	@Override
	public UserDTO loginProcess(String user_id, String user_pw) {
		System.out.println("=====================ser"+user_id + user_pw+"=====================");
	
		return userdao.loginProcess(user_id, user_pw);
		
		 
	}

	@Override
	public List<UserDTO> memberCheckProcess(String user_id, String user_email) {
		
		return userdao.memberCheckProcess(user_id, user_email);
	}

	@Override
	public int memberJoinProcess(UserDTO dto) {
		
		return userdao.memberJoinProcess(dto);
	}
	

}
