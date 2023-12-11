package nonspring;

import java.util.HashMap;

//프론트컨트롤러(Controller) => .../hello => HelloController 호출
public class HandlerMapping {
	
	//key, value -map => ("/hello", HelloController 객체)
	HashMap<String, Controller> mappings;
	
	HandlerMapping(){
		mappings = new HashMap();
		mappings.put("hello", new HelloController());
		mappings.put("list", new ListController());
	}
	
	Controller getController(String url) {
		return mappings.get(url);
	}
	
}
