package spring.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMybatisController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("/memberlist")
	public ModelAndView memberList() {
		
		List<MemberDTO> list = service.memberList();
		ModelAndView mv = new ModelAndView();
		int totalCount = service.memberCount();
	
		mv.addObject("memberlist", list);
		mv.addObject("memberCount", "총 인원은" + totalCount + "명 입니다");
		mv.setViewName("mybatis/memberlist");
		
		return mv;
	}
	

	
	@RequestMapping("/membersearchlist")
	public ModelAndView memberSearchList(String item, String searchword) {
		List<MemberDTO> list = service.memberSearchList(item, searchword);
		
		ModelAndView mv = new ModelAndView();
		int searchMemberCount = service.memberCount(item, searchword);
		
		mv.addObject("memberCount", "검색된 인원은" + searchMemberCount +"명입니다");
		mv.addObject("memberlist", list);
		mv.setViewName("mybatis/memberlist");
		
		return mv;
	}
	
	@GetMapping("/registermember")
	public String registerMember() {
		return "mybatis/registermember";
	}
	
	@PostMapping("/registermember")
	public String registerMemberResult(MemberDTO dto) {
		
		
		String result = service.registerMember(dto);
		if(result.equals("아이디 중복 -회원 가입 불가능합니다")) {
			return "mybatis/registermember";
		}else {
			//return "mybatis/memberlist"; 
			//이렇게보내버리면 model들이 만들어지지않고 그대로 뷰로 가기때문에 오류가 뜸 => memberList()메서드 호출해야함
			return "redirect:/memberlist"; 
		}
		
		
		
	}
	
}
