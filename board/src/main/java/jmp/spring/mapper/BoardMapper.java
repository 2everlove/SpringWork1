package jmp.spring.mapper;

import java.util.List;

import jmp.spring.domain.BoardVO;
import jmp.spring.domain.Criteria;

public interface BoardMapper {
	
	//insert
	int insert(BoardVO board);
	
	//delete
	int delete(Long bno);
	
	//selectOne
	BoardVO select(Long bno);
	
	//list
	List<BoardVO> getList();
	
	//paging
	List<BoardVO> getListWithPaging(Criteria cri);	
	
	//update
	int update(BoardVO board);
	
	//insert (return bno)
	void insertSelectKey(BoardVO board);
	
	//total (몇 페이지까지?) 
	int getTotal(Criteria cri);
	
}
