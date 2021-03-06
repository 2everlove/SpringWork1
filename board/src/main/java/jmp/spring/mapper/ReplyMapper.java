package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.domain.Criteria;
import jmp.spring.domain.ReplyVO;

public interface ReplyMapper {
	
	public ReplyVO get(Long rno);
	
	public List<ReplyVO> getList(@Param("bno") Long bno, @Param("cri") Criteria cri);
	
	public int insert(ReplyVO reply);
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	public int getTotal(Long bno);
	
	
}
