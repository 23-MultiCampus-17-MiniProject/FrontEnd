package com.mc.multicinema.theater.dto;

public class TheaterDTO {
	
	int theater_id;
	int cinema_id;
	int total_seat_count;
	String theater_name;
	
	
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public int getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}
	public int getTotal_seat_count() {
		return total_seat_count;
	}
	public void setTotal_seat_count(int total_seat_count) {
		this.total_seat_count = total_seat_count;
	}
	public String getTheater_name() {
		return theater_name;
	}
	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}
	
	
	
}
