package mika.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mika.spring.vo.BoardVO;

@Service
public interface BoardService {

	public List<BoardVO> getList(); 
	
	public int register(BoardVO board);
	
	public BoardVO detail(Long bno);
	
}
