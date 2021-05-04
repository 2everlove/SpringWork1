package jmp.spring.domain;

import java.util.UUID;

import lombok.Data;

@Data
public class AttachFileVO {
	private Long attachNo; //첨부파일 번호
	private	String uuid; //중복처리를 위한 랜덤값 uuid
	private String uploadPath; //업로드 경로 (년/월/일)
	private String fileName; //uuid+파일이름
	private String filetype; //파일타입 (이미지? "Y","N")
	private String regdate; //생성일
	
	private String savepath; //파일경로+uuid+파일이름
	private String s_savepath;
	
	public AttachFileVO(Long attachNo, String uploadPath, String fileName) {
		UUID uuid = UUID.randomUUID();
		this.uuid = uuid.toString();
		this.filetype = "N"; //기본은 N , image일때만 Y로 변하게 ajaxController에서 처리
		
		this.attachNo = attachNo;
		this.uploadPath = uploadPath;
		this.fileName = fileName;
		this.savepath = uploadPath+uuid+"_"+fileName;
		this.s_savepath = uploadPath+"s_"+uuid+"_"+fileName;
	}
}
