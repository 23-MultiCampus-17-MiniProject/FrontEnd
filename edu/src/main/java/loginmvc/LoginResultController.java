package loginmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ModelAndView mv = new ModelAndView();
		LoginDTO dto = new LoginDTO(id, pw);
		
		mv.addObject("login", dto);
		mv.setViewName("xml/loginresult");
		
		return mv;
	}

}
