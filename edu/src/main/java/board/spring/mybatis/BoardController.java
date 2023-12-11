package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/")
	String Start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	String boardwrite() {
		return "board/write";
	}
	
	@PostMapping("/boardwrite")
	ModelAndView writeProcess(BoardDTO dto) {
		service.registerBoard(dto);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/start");
		return mv;
	}
	
	@RequestMapping("/boardlist")
	ModelAndView boardlist(@RequestParam(value="pagenum", required=false, defaultValue="1") int pagenum) {
		if(pagenum == 0) {
			pagenum = 1;
		}
		int pagecount = 3;
		
		List<BoardDTO> list = service.pagingBoardlist(pagenum, pagecount);
		ModelAndView mv = new ModelAndView();
		mv.addObject("paginBoardlist", list);
		mv.setViewName("board/boardlist");
		
		int totalCount = service.getTotalBoard();
		mv.addObject("totalcount" , totalCount);
		mv.addObject("pagecount", pagecount);
		
		return mv;
	}
	@RequestMapping("/boarddetail")
	ModelAndView boarddetail(int seq){
		
		BoardDTO dto = service.boarddetail(seq);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("board/detail");
		
		return mv;
	}
	@RequestMapping("/boardupdate")
	String updateBoard(BoardDTO dto) {
		service.updateBoard(dto);
		
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boarddelete")
	String deleteBoard(int seq) {
		service.deleteBoard(seq);
		
		return "redirect:/boardlist";
	}
}
