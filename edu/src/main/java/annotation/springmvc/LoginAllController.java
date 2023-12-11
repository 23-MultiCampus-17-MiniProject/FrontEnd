package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAllController {
//LoginFormController + LoginResultController
//1. 로그인폼 화면 요청 2. 로그인 입력 처리 결과 화면
	//@RequestMapping(value= "/login", method=RequestMethod.GET) // get요청만 가능하게
	@GetMapping("/login")
	public ModelAndView loginform() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "양식");
		mv.setViewName("loginform");
		return mv;
	}
	//test5
	@PostMapping("/login")
	public ModelAndView loginresult(@ModelAttribute("login") LoginDTO dto, int age) { 
			
		ModelAndView mv = new ModelAndView();
		//mv.addObject("login", dto);
		mv.setViewName("loginresult");
		
		return mv;
	}
	
	
	//test4
	/*@PostMapping("/login")
	public ModelAndView loginresult(LoginDTO dto) { //dto id, pw 자동 주입 + setter 메서드가 있어야함
			
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", dto);
		mv.setViewName("loginresult");
		
		return mv;
	}*/
	
	
	
	//test3
	/*@PostMapping("/login")
	public ModelAndView loginresult(
			@RequestParam(value="memberid", required = false, defaultValue="spring")String id, String pw) {
			//memberid라는 파라미터를 id에 매핑시키는데 반드시 있어야하는 값이냐 x 만약 값이 없으면 spring이라는 값 기본으로
			//loginform에서 name 속성과 이름이 달라도 이렇게 매핑 가능
		ModelAndView mv = new ModelAndView();
		LoginDTO dto = new LoginDTO(id, pw);
		
		mv.addObject("login", dto);
		mv.setViewName("loginresult");
		
		return mv;
	}*/
	
	
	//test 2
	/*@PostMapping("/login")
	public ModelAndView loginresult(String id, String pw) {
	//매개변수이름을 파라미터와 똑같이 짓는다면 getParameter 없이 바로 집어넣을수있음
	//다만 한글 깨지는 문제가 발생가능 => web.xml에서 필터처리
		ModelAndView mv = new ModelAndView();
		LoginDTO dto = new LoginDTO(id, pw);
		
		mv.addObject("login", dto);
		mv.setViewName("loginresult");
		
		return mv;
	}*/
	
	//test 1
	//@RequestMapping(value= "/login", method=RequestMethod.POST)
	/*@PostMapping("/login")
	public ModelAndView loginresult(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ModelAndView mv = new ModelAndView();
		LoginDTO dto = new LoginDTO(id, pw);
		
		mv.addObject("login", dto);
		mv.setViewName("loginresult");
		
		return mv;
	}*/
	
}
