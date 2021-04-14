package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.domain.BoardVO;
import jmp.spring.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList.....");
		return boardMapper.getList();
	}

	@Override
	public Long register(BoardVO board) {
		log.info("register......"+board);
		boardMapper.insertSelectKey(board);
		return board.getBno();
		
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get.........."+bno);
		return boardMapper.select(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify........"+board);
		return boardMapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove....."+bno);
		return boardMapper.delete(bno) == 1;
	}

}
