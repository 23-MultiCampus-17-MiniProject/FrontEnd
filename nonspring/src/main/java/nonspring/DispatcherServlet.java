package nonspring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url을 분석 
//.../hello
//.../login
@WebServlet("/") //뭘받아도 다 여기를 통함
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri = req.getRequestURI();
		String[] uri_array = uri.split("/");
		String result = uri_array[uri_array.length - 1];
		System.out.println("요청 uri = " + result);
		
		HandlerMapping mappings = new HandlerMapping();
		Controller controller = mappings.getController(result); //url에 매핑된 컨트롤러 찾기
		String viewName = controller.handleRequest(req, resp);//HelloDTO-->모델(model) 생성 + 뷰리턴
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);//뷰 이동
		dispatcher.forward(req, resp);
	}
	
}
