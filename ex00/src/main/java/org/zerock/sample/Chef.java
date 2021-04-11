package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

//오랫동안 쓰는 객체는 spring의 bean에 넣어야 함
//@방법, xml방법이 있음

@Component
@Data
public class Chef {
	//interface를 쓰는게 좋음 -> 객체를 몰라도 됨, 타입에 의존하므로
	
}
