package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmp.spring.domain.Criteria;
import jmp.spring.domain.ReplyVO;
import jmp.spring.mapper.BoardMapper;
import jmp.spring.mapper.ReplyMapper;
import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_= {@Autowired})
	private ReplyMapper mapper;
	
	@Setter(onMethod_= {@Autowired})
	private BoardMapper boardMapper;

	@Override
	public ReplyVO get(Long rno) {
		return mapper.get(rno);
	}

	@Override
	public List<ReplyVO> getList(Long bno, Criteria cri) {
		return mapper.getList(bno, cri);
	}

	@Transactional
	@Override
	public int insert(ReplyVO reply) {
		//댓글의 갯수를 count -> tbl_board (replycnt) update
		Long bno = reply.getBno();
		boardMapper.updateTotal(bno);
		return mapper.insert(reply);
	}
	
	@Transactional
	@Override
	public int delete(Long rno) {
		ReplyVO reply = mapper.get(rno);
		Long bno = reply.getBno();
		int res = mapper.delete(rno);
		boardMapper.updateTotal(bno);
		return res;
	}

	@Override
	public int update(ReplyVO reply) {
		return mapper.update(reply);
	}

	@Override
	public int getTotal(Long bno) {
		return mapper.getTotal(bno);
	}

}
