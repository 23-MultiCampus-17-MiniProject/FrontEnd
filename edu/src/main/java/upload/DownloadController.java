package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	
	@GetMapping("/filedownloadlist")
	ModelAndView downloadlist() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("c:/fullstack/upload");//파일 시스템 정보를 가진 객체 생성
		String[] filearray = f.list();
		
		mv.addObject("filearray", filearray);
		mv.setViewName("upload/download");
		
		return mv;	
	}
	
	@GetMapping("/filedownloadresult")
	void downloadresult(String filename, HttpServletResponse response) throws IOException{
		response.setContentType("application/download");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"" );//다운로드해야할 파일의 이름
		File f = new File("c:/fullstack/upload/" + filename);
		response.setContentLength((int)f.length());//다운로드할 파일 길이
		
		OutputStream out;
		
			out = response.getOutputStream();
			FileInputStream fi = new FileInputStream(f);
			FileCopyUtils.copy(fi, out);
			fi.close();
			out.close();
		
		
		
	}
	
}
