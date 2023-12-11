package edu.multi.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/ajaxstart")
	String start() {
		
		return "start";
	}
	
	@RequestMapping("/ajaxend")
	String end() {
		return "end";
	}
	
}
