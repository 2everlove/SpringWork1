package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//field / setter / constructor

@Component
@ToString
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	
	//private Chef chef;
	private final Chef chef;
	
	/*
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
	*/

}
