package jmp.spring.mapper;

import java.util.List;

import jmp.spring.domain.ReplyVO;

public interface ReplyMapper {
	
	public ReplyVO get(Long rno);
	
	public List<ReplyVO> getList(Long bno);
	
	public int insert(ReplyVO reply);
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	public int getTotal(Long bno);
}
