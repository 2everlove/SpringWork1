package jmp.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jmp.spring.domain.Criteria;
import jmp.spring.domain.ReplyVO;

@Service
public interface ReplyService {
	
	public ReplyVO get(Long rno);
	
	public List<ReplyVO> getList(Long bno, Criteria cri);
	
	public int insert(ReplyVO reply);
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	public int getTotal(Long bno);
	
}
