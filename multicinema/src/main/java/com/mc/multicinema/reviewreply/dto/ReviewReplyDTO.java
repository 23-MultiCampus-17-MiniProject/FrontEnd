package com.mc.multicinema.reviewreply.dto;

import org.springframework.stereotype.Component;

@Component
public class ReviewReplyDTO {
	
	int reply_num;
	int board_num;
	int user_key;
	String reply_content;
	String reply_write_date;
	int reply_like_count;
	int reply_dislike_count;
	boolean is_deleted;
	String deleted_date;
	
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
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
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_write_date() {
		return reply_write_date;
	}
	public void setReply_write_date(String reply_write_date) {
		this.reply_write_date = reply_write_date;
	}
	public int getReply_like_count() {
		return reply_like_count;
	}
	public void setReply_like_count(int reply_like_count) {
		this.reply_like_count = reply_like_count;
	}
	public int getReply_dislike_count() {
		return reply_dislike_count;
	}
	public void setReply_dislike_count(int reply_dislike_count) {
		this.reply_dislike_count = reply_dislike_count;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public String getDeleted_date() {
		return deleted_date;
	}
	public void setDeleted_date(String deleted_date) {
		this.deleted_date = deleted_date;
	}
	
	
}
