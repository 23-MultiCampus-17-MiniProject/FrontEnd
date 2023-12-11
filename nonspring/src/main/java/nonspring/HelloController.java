package nonspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
	//컨트롤러 - 처리결과 저장 모델 생성 -> 어느 view로 보낼지
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HelloDTO dto =  new HelloDTO();
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델 객체입니다");
		request.setAttribute("model", dto);
		return "hello.jsp"; //view의 이름
	}

}
