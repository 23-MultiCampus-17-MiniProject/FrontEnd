package com.mc.multicinema.reviewboard.dto;

public class ReviewBoardDTO {
	
	int board_num;
	int user_key;
	int movie_cd;
	String board_write_date;
	String board_title;
	String board_content;
	String board_update_date;
	int board_like_count;
	int board_dislike_count;
	int board_comment_count;
	
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getUser_key() {
		return user_key;
	}
	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}
	public int getMovie_cd() {
		return movie_cd;
	}
	public void setMovie_cd(int movie_cd) {
		this.movie_cd = movie_cd;
	}
	public String getBoard_write_date() {
		return board_write_date;
	}
	public void setBoard_write_date(String board_write_date) {
		this.board_write_date = board_write_date;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_update_date() {
		return board_update_date;
	}
	public void setBoard_update_date(String board_update_date) {
		this.board_update_date = board_update_date;
	}
	public int getBoard_like_count() {
		return board_like_count;
	}
	public void setBoard_like_count(int board_like_count) {
		this.board_like_count = board_like_count;
	}
	public int getBoard_dislike_count() {
		return board_dislike_count;
	}
	public void setBoard_dislike_count(int board_dislike_count) {
		this.board_dislike_count = board_dislike_count;
	}
	public int getBoard_comment_count() {
		return board_comment_count;
	}
	public void setBoard_comment_count(int board_comment_count) {
		this.board_comment_count = board_comment_count;
	}
	
	
}
