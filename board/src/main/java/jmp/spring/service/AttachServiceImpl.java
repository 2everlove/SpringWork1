package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.domain.AttachFileVO;
import jmp.spring.mapper.AttachMapper;
import lombok.Setter;

@Service
public class AttachServiceImpl implements AttachService {

	@Setter(onMethod_= @Autowired)
	private AttachMapper mapper;
	
	@Override
	public Long getSeq() {
		Long res = mapper.getSeq();
		return res;
	}

	@Override
	public int insert(AttachFileVO attachFileVO) {
		int res = mapper.insert(attachFileVO);
		return res;
	}

	@Override
	public List<AttachFileVO> getList(Long attachNo) {
		List<AttachFileVO> list = mapper.getList(attachNo);
		return list;
	}

}
