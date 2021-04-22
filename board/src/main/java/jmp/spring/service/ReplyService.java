package jmp.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jmp.spring.domain.ReplyVO;

@Service
public interface ReplyService {
	
	public ReplyVO get(Long rno);
	
	public List<ReplyVO> getList(Long bno);
	
	public int insert(ReplyVO reply);
	
	public int delete(ReplyVO reply);
	
	public int update(ReplyVO reply);
}
