package com.mc.multicinema.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mc.multicinema.user.dto.UserDTO;
import com.mc.multicinema.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@GetMapping("/login")
	public String login() {
		//로그인 이미 했을때 처리
		return "login";
	}
	
	@PostMapping("/login")
	public String loginProcess(String user_id, String user_pw, Model m, HttpSession session) {
		
		//id, pw 정보 있는지 확인
		//있으면 return 로그인을 눌렀던 그 페이지로
		//정보 있음
		System.out.println("=====================con"+user_id + user_pw+"=====================");
		UserDTO dto = userservice.loginProcess(user_id, user_pw);
		
		if(dto != null && dto.getUser_key() != null && dto.getUser_name() != null && dto.getUser_id() != null) {
			session.setAttribute("login_user_id", dto.getUser_id());
			session.setAttribute("login_user_key", dto.getUser_key());
			session.setAttribute("login_user_name", dto.getUser_name());
			
			
			//세션에 추가할 것
			//user_key,
			//아이디, 이름,
			return "redirect:/";
		}else {
			m.addAttribute("result", "아이디와 비밀번호가 일치하지 않습니다");
			return "login";
		}
	}
	
	@GetMapping("/membercheck")
	public String memberCheck() {
		return "member_check";
	}
	
	@PostMapping("/membercheck")

	public String memberCheckProcess(String user_id, String user_email, Model m) {
		
		//서비스 dao 멤버 있는지 확인 후
		//있다 modelandview 생성 후 model에 아이디 이메일값 넣어주고 회원가입 페이지로
		//없다 modelandview 생성 후 model에 이미 있는 회원이다 하고 모델만 주기
		//jsp에선 ${모델이름명}으로 들고와서 스크립트에서 alert 띄워주기
		List<UserDTO> list = userservice.memberCheckProcess(user_id, user_email);
		
		if(list.size() == 0) {
			m.addAttribute("result", "가입가능");
			m.addAttribute("user_id", user_id);
			m.addAttribute("user_email", user_email);
			return "member_check";
		}else {
			m.addAttribute("result", "이미 존재하는 회원입니다");
			return "member_check";
		}
	}
	

	
	@PostMapping("/memberjoin")
	public ModelAndView memberjoin(String user_id, String user_email) {
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user_id", user_id);
		mv.addObject("user_email", user_email);
		mv.setViewName("member_join");
		
		return mv;
	}
	
	@PostMapping("/welcome")
	public String welcome(UserDTO dto, Model m) {
		int res = userservice.memberJoinProcess(dto);
		if(res == -1) {
			System.out.println("db 오류");
			return "redirect:/memberjoin";
		}else {
			m.addAttribute("user_name", dto.getUser_name());
			return "welcome";
		}
		
		
	}
}
