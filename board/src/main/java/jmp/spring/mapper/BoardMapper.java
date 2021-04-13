package jmp.spring.mapper;

import java.util.List;

import jmp.spring.domain.BoardVO;

public interface BoardMapper {
	
	int insert(BoardVO board);
	
	int delete(Long bno);
	
	BoardVO select(Long bno);
	
	List<BoardVO> getList();
}
