package mika.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import mika.spring.mapper.BoardMapper;
import mika.spring.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_= @Autowired)
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	@Override
	public int register(BoardVO board) {
		int res = boardMapper.insert(board);
		return res;
	}

	@Override
	public BoardVO detail(Long bno) {
		BoardVO board = boardMapper.getBoard(bno);
		return board;
	}

	
	
}
