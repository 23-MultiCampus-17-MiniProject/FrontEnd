package nonspring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<HelloDTO> list = new ArrayList<>();
		HelloDTO dto1 = new HelloDTO();
		dto1.setMessage("HelloDTO 3개 중 첫번째");
		list.add(new HelloDTO());
		HelloDTO dto2 = new HelloDTO();
		dto1.setMessage("HelloDTO 3개 중 두번째");
		list.add(new HelloDTO());
		HelloDTO dto3 = new HelloDTO();
		dto1.setMessage("HelloDTO 3개 중 세번째");
		list.add(new HelloDTO());
		
		request.setAttribute("modelList", list);
		return "/list.jsp";
	}

}
