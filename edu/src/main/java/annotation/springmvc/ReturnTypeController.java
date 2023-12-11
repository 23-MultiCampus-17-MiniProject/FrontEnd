package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView m = new ModelAndView();
		m.addObject("mode", "a 메소드 호출");
		m.setViewName("aa");
		return m;
	}
	
	//모델(컨트롤러가 만들어서 jsp보내는 전달 값) 없다 => modelandview 필요없음 대신 뷰만
	@RequestMapping("/b")
	public String b() {
		
		
		return "bb"; //view의 이름
	}
	
	//모델x 뷰네임 = url
	@RequestMapping("/c")
	public void c() {
	
	//view의 이름과 url이 같으면 리턴값 없어도 됨
	}
	
	
	@RequestMapping("/d")
	public void d(@ModelAttribute LoginDTO dto) {
				//뒤에("loginDTO") 안붙여도 됨 생략하면 LoginDTO에서 앞자리 소문자로 자동 설정
		
	//view의 이름과 url이 같으면 리턴값 없어도 됨
	}
	
	@RequestMapping("/e")
	public String e() {
		//같은 컨트롤러 안에 다른 매서드 호출
		//a(); 는 안됨
		return "redirect:/a"; // /e를 요청한 사람에게 /a로 보낸다
		// return "aa"; 이렇게도 aa.jsp로 갈수있지만 모델정보는 못보여줌 
	}
	
	@RequestMapping("/f")
	public void f(Model model, ModelMap modelmap) {
		
	//	ModelMap modelmap = new ModelMap();
		
		model.addAttribute("model", "springtest1");
		modelmap.addAttribute("modelmap", "springtest2");
	//	return modelmap; 직접 객체생성하려면 return해줘야함
	}
	
}
