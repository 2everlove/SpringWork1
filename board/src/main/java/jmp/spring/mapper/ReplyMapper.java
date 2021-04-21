package jmp.spring.mapper;

import java.util.List;

import jmp.spring.domain.ReplyVO;

public interface ReplyMapper {
	
	public ReplyVO get(Long rno);
	
	public List<ReplyVO> getList(Long bno);
	
	public int insert(ReplyVO reply);
	
	public int delete(ReplyVO reply);
	
	public int update(ReplyVO reply);
}