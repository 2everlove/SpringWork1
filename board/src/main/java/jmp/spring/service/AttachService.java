package jmp.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jmp.spring.domain.AttachFileVO;

@Service
public interface AttachService {
	public Long getSeq();
	
	public int insert(AttachFileVO attachFileVO);
	
	public List<AttachFileVO> getList(Long attachNo);
}
