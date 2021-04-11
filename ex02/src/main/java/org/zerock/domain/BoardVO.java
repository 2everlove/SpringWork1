package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno; //소문자 long인 경우 0같은 기본값을 가지므로 Long형태로 씀
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
}
