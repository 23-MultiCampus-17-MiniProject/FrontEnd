package annotation.movie;

import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
		HashMap<String, Integer> moviemap = new HashMap<>();
	
	
	@RequestMapping("/movielist")
	public ModelAndView start() {
		
		moviemap.put("영화제목1", 19);
		moviemap.put("영화제목2", 13);
		moviemap.put("영화제목3", 19);
		moviemap.put("영화제목4", 0);
		moviemap.put("영화제목5", 10);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("moviemodel", moviemap);
		mv.setViewName("movie/movielist");
		
		return mv;
	}
	@RequestMapping("/moviereserve")
	public ModelAndView end(String id, String pw, int age, String[] movielist) {
		
		Set<String> movieSet = moviemap.keySet();
		String result = "";
		
		for(String mymovie : movielist) {
			for(String movie : movieSet) {
				if(movie.equals(mymovie) && moviemap.get(movie) <= age) {
					result += movie + " ";
				}
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("age", age);
		mv.addObject("result", result);
		
		mv.setViewName("movie/moviereserve");
		return mv;
	}
	
}
