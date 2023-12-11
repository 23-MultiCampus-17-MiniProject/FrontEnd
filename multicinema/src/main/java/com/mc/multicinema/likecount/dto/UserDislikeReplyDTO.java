package com.mc.multicinema.likecount.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDislikeReplyDTO {
	
	int user_key;
	int comment_num;
	
	public int getUser_key() {
		return user_key;
	}
	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
}
