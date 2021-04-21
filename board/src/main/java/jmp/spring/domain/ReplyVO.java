package jmp.spring.domain;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private String replydate;
	private String updateDate;
}
