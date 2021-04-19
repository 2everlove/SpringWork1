package jmp.spring.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage, endPage, total;
	private boolean prev, next;
	private Criteria cri;
			
	public PageDTO(Criteria cri, int total) {
		
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//10페이지 씩 보여주니깐 10.0으로 나누고 올림처리,
		this.startPage = this.endPage-9;
		
		int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd<this.endPage) { //구해논 끝번호보다 진짜 번호가 작으면 endpage를 realpage로 맞춰야함
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
	
	
	
}
