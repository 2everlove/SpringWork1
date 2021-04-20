package jmp.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum; //페이지 번호
	private int amount; //페이지 당 게시물 수
	
	private String type; // 검색 타입(제목, 내용, 작성자)
	private String keyword; //검색 단어
	
	//페이지의 값이 할당안되었을 때의 기본값
	public Criteria() {
		this(1,10);
	}
	
	//초기화
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String[] getTypeArr() {
		System.out.println("getTypeArr -------------");
		return type == null? new String[] {} : type.split("");
	}
}
