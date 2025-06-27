package com.gn.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data

public class Guest {
	private String name;
	private String text;
	private String time;
	
	public Guest(String name , String text){
		this.name=name;
		this.text=text;
		LocalDateTime t = LocalDateTime.now();
		time = t.format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh-ss"));
	}
}
