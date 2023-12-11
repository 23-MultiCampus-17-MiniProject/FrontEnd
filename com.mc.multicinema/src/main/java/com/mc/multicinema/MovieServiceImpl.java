package com.mc.multicinema;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.multicinema.moviecomment.dao.MovieCommentDAO;
import com.mc.multicinema.moviecomment.dto.MovieCommentDTO;
import com.mc.multicinema.movieinfo.dto.MovieDTO;



@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	DailyBoxOfficeDTO dto;
	@Autowired
	MovieCommentDAO mcommentdao;

	public ArrayList<DailyBoxOfficeDTO> dailyBoxOffice() {

		ArrayList<DailyBoxOfficeDTO> list = new ArrayList<>();
		try {
			JSONParser jsonparser = new JSONParser();

			JSONObject boxOfficeObj = (JSONObject) jsonparser.parse(readBoxOfficeUrl());
			JSONObject json1 = (JSONObject) boxOfficeObj.get("boxOfficeResult");
			JSONArray array1 = (JSONArray) json1.get("dailyBoxOfficeList");

			for (int i = 0; i < array1.size(); i++) {

				JSONObject entity = (JSONObject) array1.get(i);
				String movieNm = (String) entity.get("movieNm");
				if (movieNm.length() >= 13) {
					String tmp = movieNm.substring(0, 11) + "..";
					movieNm = tmp;
				}

				String movieCd_str = (String) entity.get("movieCd");
				String rank_str = (String) entity.get("rank");
				String audiAcc_str = (String) entity.get("audiAcc");// 누적 관객수

				int movieCd = Integer.parseInt(movieCd_str);
				int rank = Integer.parseInt(rank_str);
				int audiAcc = Integer.parseInt(audiAcc_str);

				JSONObject movieInfoObj = (JSONObject) jsonparser.parse(readMovieInfoUrl(movieCd));
				JSONObject json2 = (JSONObject) movieInfoObj.get("movieInfoResult");
				JSONObject json3 = (JSONObject) json2.get("movieInfo");
				JSONArray array2 = (JSONArray) json3.get("audits");
				JSONObject entity2 = (JSONObject) array2.get(0);

				String tm = (String) entity2.get("watchGradeNm");
				String grade = tm.substring(0, 2);
				if (grade.equals("전체")) {
					grade = "ALL";
				}

				DailyBoxOfficeDTO tmp = (DailyBoxOfficeDTO) dto.clone();

				tmp.setMovieNm(movieNm);
				tmp.setMovieCd(movieCd);
				tmp.setRank(rank);
				tmp.setGrade(grade);
				tmp.setAudiAcc(audiAcc);

				list.add(tmp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public MovieDTO selectMovieDetailInfo(String movie_cd) {
		
		return null;
	}
	
	@Override
	public ArrayList<String> stillCutService(String movie_title) {
		JSONParser jsonparser = new JSONParser();
		ArrayList<String> list = new ArrayList<>();
		try {
			JSONObject boxOfficeObj = (JSONObject) jsonparser.parse(readMovieStillCutUrl(movie_title));
			JSONArray array1 = (JSONArray) boxOfficeObj.get("Data");
			JSONObject json1 =  (JSONObject)array1.get(0);
			JSONArray array2 = (JSONArray) json1.get("Result");
			JSONObject json2 =  (JSONObject)array2.get(0);
			
			String stlls =  (String)json2.get("stlls");
			String[] arr = stlls.split("\\|");
			
			for(int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	private String readBoxOfficeUrl() throws Exception {
		BufferedInputStream reader = null;
		String key = "f0b5971de85c22ab8010d759968eef23";
		String targetDt = "";
		try {
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
					+ "searchDailyBoxOfficeList.json" + "?" + "key=" + key + "&targetDt=20231207");
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	private String readMovieInfoUrl(int movie_cd) throws Exception {
		BufferedInputStream reader = null;
		String key = "f0b5971de85c22ab8010d759968eef23";
		try {
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json" + "?"
					+ "key=" + key + "&movieCd=" + movie_cd);
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
	
	private String readMovieStillCutUrl(String title) throws Exception {
		BufferedInputStream reader = null;
		String key = "EVXDCBI8JN5T12ET284U";
		try {
			String encodeResult = URLEncoder.encode(title, "UTF-8");
			
			URL url = new URL("https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?"
					+ "collection=kmdb_new2&detail=Y&ServiceKey="+key+"&title="+encodeResult);
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	
	

}

