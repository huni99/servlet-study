package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Planet {
	private String name;
	private double in;
	private boolean po;
	private String poS;
	
	public Planet(String name, double in, boolean po){
		this.name = name;
		this.in =in;
		this.po = po;
		if(po==true) {
			this.poS="o";
		}else {
			this.poS="x";
		}
	}
}
