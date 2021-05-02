package mika.spring.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updateDate;
	private Long replycnt;
}
