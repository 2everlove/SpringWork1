package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.domain.AttachFileVO;

public interface AttachMapper {
	
	public Long getSeq();
	
	public int insert(AttachFileVO attachFileVO);
	
	public List<AttachFileVO> getList(Long attachNo);
	
	public int delete(@Param("uuid") String uuid, @Param("attachNo") Long attachNo);
	
	public AttachFileVO get(@Param("uuid") String uuid, @Param("attachNo") Long attachNo);
}
