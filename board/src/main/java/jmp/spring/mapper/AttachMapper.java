package jmp.spring.mapper;

import java.util.List;

import jmp.spring.domain.AttachFileVO;

public interface AttachMapper {
	
	public Long getSeq();
	
	public int insert(AttachFileVO attachFileVO);
	
	public List<AttachFileVO> getList(Long attachNo);
}
