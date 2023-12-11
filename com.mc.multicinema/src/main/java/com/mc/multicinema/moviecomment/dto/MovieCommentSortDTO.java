package com.mc.multicinema.moviecomment.dto;

import org.springframework.stereotype.Component;

@Component
public class MovieCommentSortDTO {
	
	int movie_cd;
	int commentsCount = 10;
	int commentsStart = 10;
	String sort_criteria = "comment_write_date";
	String sort_sw = "desc";
	
	
	public int getMovie_cd() {
		return movie_cd;
	}
	public void setMovie_cd(int movie_cd) {
		this.movie_cd = movie_cd;
	}
	public int getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}
	public int getCommentsStart() {
		return commentsStart;
	}
	public void setCommentsStart(int commentsStart) {
		this.commentsStart = commentsStart;
	}
	public String getSort_criteria() {
		return sort_criteria;
	}
	public void setSort_criteria(String sort_criteria) {
		this.sort_criteria = sort_criteria;
	}
	public String getSort_sw() {
		return sort_sw;
	}
	public void setSort_sw(String sort_sw) {
		this.sort_sw = sort_sw;
	}
	
	
}
