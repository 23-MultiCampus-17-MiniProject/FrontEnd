package annotation.spring.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberServiceController {
	@Autowired
	@Qualifier("service1")
	MemberService basicService;
	
	@Autowired
	@Qualifier("service2")
	MemberService janService;
	
	@GetMapping("/memberservice")
	public void memberform(){
		
	}
	
	@PostMapping("/memberservice")
	public ModelAndView memberresult(MemberDTO dto){
		String month = dto.getRegdate().split("-")[1];
		String result = "";
		//객체 2개 중 하나 선택하는 방법
		if(month.equals("01")) {
			result = janService.registerMember(dto);
		}else {
			result = basicService.registerMember(dto);
		}
		//dto의 변수값과 파라미터 name값이 같으므로 그대로 저장됨
		ModelAndView mv = new  ModelAndView();
		//memberbasicservice써야하지만 직접 객체생성 ㄴㄴ
		
		mv.addObject("result", result);
		mv.setViewName("memberserviceresult");
		
		return mv;
		
	}
}
