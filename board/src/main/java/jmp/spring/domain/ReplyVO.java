package jmp.spring.domain;

import lombok.Data;

@Data
public class ReplyVO {
	//리플 번호
	private Long rno;
	//게시물 번호
	private Long bno;
	//리플
	private String reply;
	//리플라이어
	private String replyer;
	//작성일
	private String replydate;
	//수정일
	private String updateDate;
}
