package jmp.spring.service;

import java.util.List;

import jmp.spring.domain.BoardVO;
import jmp.spring.domain.Criteria;

public interface BoardService {
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	//public List<BoardVO> getList();
	
	public Long register(BoardVO board);
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal();
}
