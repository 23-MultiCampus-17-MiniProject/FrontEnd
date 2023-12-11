package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@GetMapping("/fileupload")
	String uploadform() {
		return "upload/uploadform";
	}
	
	@PostMapping("/fileupload")
	ModelAndView uploadresult(UploadDTO dto) throws IOException{
		String savePath = "c:/fullstack/upload/";
		String filename1 = null;
		String newfilename1 = null;
		String filename2 = null;
		String newfilename2 = null;
		MultipartFile file1 = dto.getFile1();
		if(file1.isEmpty() == false) {
			filename1 = file1.getOriginalFilename();
			
			String beforeext1 = filename1.substring(0, filename1.lastIndexOf("."));
			String ext1 = filename1.substring(filename1.indexOf("."));
			newfilename1 = beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
			
			File savefile1 = new File(savePath + newfilename1); // 경로+파일이름으로 빈 파일 생성
			file1.transferTo(savefile1); //빈 파일에 내용 채워넣기
		}
		
		
		MultipartFile file2 = dto.getFile2();
		if(file2.isEmpty() == false) {
			filename2 = file2.getOriginalFilename();
			
			String beforeext2 = filename2.substring(0, filename2.lastIndexOf("."));
			String ext2 = filename2.substring(filename2.indexOf("."));
			newfilename2 = beforeext2 + "(" + UUID.randomUUID().toString() + ")" + ext2;
			
			File savefile2 = new File(savePath + filename2); // 경로+파일이름으로 빈 파일 생성
			file2.transferTo(savefile2); //빈 파일에 내용 채워넣기, 업로드 스트림을 파일형태 저장
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("saveresult1", filename1 + "파일을 " + savePath +"에 "+ newfilename1 + "로 저장했습니다");
		mv.addObject("saveresult2", filename2 + "파일을 " + savePath +"에 "+ newfilename2 + "로 저장했습니다");
		mv.setViewName("upload/uploadresult");
		
		return mv;
	}
}
