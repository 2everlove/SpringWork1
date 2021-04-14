package jmp.spring.service;

import java.util.List;

import jmp.spring.domain.BoardVO;

public interface BoardService {
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList();
	
	public Long register(BoardVO board);
}
