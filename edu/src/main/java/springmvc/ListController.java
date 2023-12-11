package springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		ArrayList<HelloDTO> list = new ArrayList<>();
		
		HelloDTO dto1 = new HelloDTO();
		dto1.setMessage("HelloDTO 3개 중 첫번째");
		list.add(dto1);
		
		HelloDTO dto2 = new HelloDTO(); 
		dto2.setMessage("HelloDTO 3개 중 두번째");
		list.add(dto2);
		
		HelloDTO dto3 = new HelloDTO();
		dto3.setMessage("HelloDTO 3개 중 세번째");
		list.add(dto3);
		
		mv.addObject("modellist", list);
		mv.setViewName("xml/list"); //.jsp 안넣는 이유 이미 servlet-context.xml에 설정되어있기 때문
		 
		request.setAttribute("modelList", list);
		return mv;
	}
	 

}
