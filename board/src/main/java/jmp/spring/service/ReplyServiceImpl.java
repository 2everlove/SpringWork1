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
		int res = mapper.insert(reply);
		//댓글의 갯수를 count -> tbl_board (replycnt) update
		Long bno = reply.getBno();
		boardMapper.updateTotal(bno);
		return res;
	}
	
	@Transactional
	@Override
	public int delete(Long rno) {
		//rno에 해당하는 reply조회 후 객체 생성
		ReplyVO reply = mapper.get(rno);
		//reply에 해당하는 객체에서 bno꺼내 온 뒤 Long var에 저장
		Long bno = reply.getBno();
		//그 후 delete() 로직 실행
		int res = mapper.delete(rno);
		//삭제 후 해당 bno에 해당하는 게시글의 replyCNT를 업데이트
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
