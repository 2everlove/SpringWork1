package jmp.spring.domain;

import lombok.Data;

@Data
public class AttachFileVO {
	private Long attachNo;
	private	String uuid;
	private String uploadPath;
	private String fileName;
	private String filetype;
	private String regdate;
	
	private String savepath;
	private String s_savepath;
}
