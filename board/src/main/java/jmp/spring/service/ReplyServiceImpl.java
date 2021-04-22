package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.domain.ReplyVO;
import jmp.spring.mapper.ReplyMapper;
import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_= {@Autowired})
	private ReplyMapper mapper;

	@Override
	public ReplyVO get(Long rno) {
		return mapper.get(rno);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		// TODO Auto-generated method stub
		return mapper.getList(bno);
	}

	@Override
	public int insert(ReplyVO reply) {
		return mapper.insert(reply);
	}

	@Override
	public int delete(ReplyVO reply) {
		return mapper.delete(reply);
	}

	@Override
	public int update(ReplyVO reply) {
		return mapper.update(reply);
	}

}
