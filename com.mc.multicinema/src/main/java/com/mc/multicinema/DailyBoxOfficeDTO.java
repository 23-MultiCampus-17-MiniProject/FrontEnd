package com.mc.multicinema;

import org.springframework.stereotype.Component;

@Component
public class DailyBoxOfficeDTO implements Cloneable{
	String movieNm;
	int movieCd;
	int rank;
	String grade;
	int audiAcc;
	
	
	public String getMovieNm() {
		return movieNm;
	}


	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}


	public int getMovieCd() {
		return movieCd;
	}


	public void setMovieCd(int movieCd) {
		this.movieCd = movieCd;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getAudiAcc() {
		return audiAcc;
	}


	public void setAudiAcc(int audiAcc) {
		this.audiAcc = audiAcc;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	
}
