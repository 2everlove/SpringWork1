package mika.spring.mapper;

import java.util.List;

import mika.spring.vo.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> getList();
	
	public int insert(BoardVO board);
	
	public BoardVO getBoard(Long bno);
	
}
