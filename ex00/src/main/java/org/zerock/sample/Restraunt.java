package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//setter 주입
//constructor 주입
//field 주입

@Component //spring에서 관리하도록 component 선언
@ToString
//@AllArgsConstructor //생성자 생성
@RequiredArgsConstructor //final 필드 주입 - *주로 쓰는 방법*
public class Restraunt {
	
	//@Setter(onMethod_ = {@Autowired}) //set method
	//private Chef chef;
	
	private final Chef chef;
}
