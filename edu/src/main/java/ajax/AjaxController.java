package ajax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import upload.MemberDTO;

@Controller
public class AjaxController {
	
	ArrayList<MemberDTO> list = new ArrayList<>();
	
	
	@RequestMapping("/ajaxstart")
	String start() {
		return "ajax/start";
	}
	@RequestMapping("/nonajaxlogin")
	String nonajaxlogin(Model m, String memberid, String pw){
		String result = null;
		if(memberid.equalsIgnoreCase("ajax") && pw.equals("1234")) {
			result = "로그인 성공";
		}else {
			result = "로그인 실패";
		}
		m.addAttribute("loginresult", result);
		return "ajax/nonajax";
	}
	
	
	@RequestMapping(value="/ajaxlogin", produces = {"application/json;charset=utf-8"})
	//response.setContentType("application/json;charset=utf-8")과 같음 여러개가 들어갈수있으므로 배열타입{}
	@ResponseBody
	String ajaxlogin(String memberid, String pw){
		String result = null;
		if(memberid.equalsIgnoreCase("ajax") && pw.equals("1234")) {
			result = "로그인성공";
		}else {
			result = "로그인실패";
		}
		return "{\"loginresult\": \"" + result + "\"}";
		
	}
	
	@PostMapping("/ajaxmypage")
	public @ResponseBody MemberDTO ajaxmypage(String memberid, String pw){
		MemberDTO dto = new MemberDTO();
		if(memberid.equalsIgnoreCase("ajax") && pw.equals("1234")) {
			dto.setMemberid(memberid);
			dto.setPw(pw);
			dto.setMembername("김정희");
			dto.setPhone("010-1111-2222");
			dto.setEmail("Asd@akdwok.com");
			dto.setRegdate("2013-11-20 12:32:12");
		}else {
			dto.setMemberid(memberid);
			dto.setPw(pw);
		}
		return dto;
	}
	
	@PostMapping("/ajaxlist")
	public @ResponseBody ArrayList<MemberDTO> ajaxlist(String memberid, String pw){
		
		for(int i = 1; i <= 5; i++) {
			MemberDTO dto = new MemberDTO();
			dto.setMemberid("ajax" + i);
			dto.setPw("pw" + i);
			dto.setMembername("이름" + i);
			dto.setEmail("이메일@nam.com" + i);
			dto.setPhone("010-1231-123" + i);
			list.add(dto);
		}
		if(memberid.equals("admin")&&pw.equals("admin")) {
			return list;
		}else {
			return null;
		}
		
	}
	
	@RequestMapping(value = "ajaxgetpw/{id}" , produces = {"application/json;charset=utf-8"})
	@ResponseBody
	String ajaxgetpw(@PathVariable("id") String memberid){
		
		for(MemberDTO dto : list) {
			if(dto.getMemberid().equals(memberid)) {
				return "{\"pw\" : \""+dto.getPw()+"\"}";
			}
		}
		return "몰러";
//		if(memberid.equals("ajax")) {
//			return "{\"pw\" : \"1234\"}";
//		}else {
//			return "{\"pw\" : \"꺼져\"}";
//		}
	}
	
	@PostMapping(value="/ajaxupload" , produces = {"application/json;charset=utf-8"})
	public @ResponseBody String ajaxupload(MultipartFile uploadfile) throws IllegalStateException, IOException {
		String savePath = "c:/fullstack/upload/";

		String filename1 = null;
		String newfilename1 = null;
		
		MultipartFile file1 = uploadfile;
		if(file1.isEmpty() == false) {
			
			filename1 = file1.getOriginalFilename();
			
			String beforeext1 = filename1.substring(0, filename1.lastIndexOf("."));
			String ext1 = filename1.substring(filename1.indexOf("."));
			newfilename1 = beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
			
			File savefile1 = new File(savePath + newfilename1); // 경로+파일이름으로 빈 파일 생성
			file1.transferTo(savefile1);
		}
		
		return "{\"uploadresult\" : \"서버에 저장했습니다\"}";
	}
	
	
}
