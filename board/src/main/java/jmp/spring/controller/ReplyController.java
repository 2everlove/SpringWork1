package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.domain.ReplyVO;
import jmp.spring.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply/*")
@Log4j
public class ReplyController {
	
	@Setter(onMethod_= {@Autowired})
	ReplyService service;
	/*
	@Setter(onMethod_= {@Autowired})
	BoardService bService;
	
	@GetMapping("/test")
	public String restTest() {
		return "Test";
	}
	
	
	@GetMapping("/test1") 
	public BoardVO objectTest() { 
		return bService.get(7L); 
	}
	
	@GetMapping("/test2") 
	public ResponseEntity<List<BoardVO>> objectTest2() { 
		Criteria cri = new Criteria();
		//return new ResponseEntity<List<BoardVO>>(service.getList(cri), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<List<BoardVO>>(bService.getList(cri), HttpStatus.valueOf(200));
		//return service.getList(cri); 
	}
	
	//url에 값을 넣을 수 있게 @GetMapping("path/{var}") @PathVariable("var")을 지정하면 
	//url(http://localhost:8090/path/var)의 변수를 받고 page에 데이터을 넣어줌
	@GetMapping("/test/{pageNo}") 
	public ResponseEntity<List<BoardVO>> restPathTest(@PathVariable("pageNo") int pageNo) {
		log.info("restPathTest......."+pageNo);
		int amount = 3;
		Criteria cri = new Criteria();
		cri.setAmount(amount);
		cri.setPageNum(pageNo);
		//return new ResponseEntity<List<BoardVO>>(service.getList(cri), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<List<BoardVO>>(bService.getList(cri), HttpStatus.valueOf(200));
		//return service.getList(cri); 
	}
	*/
	@GetMapping("/list/{bno}")
	public List<ReplyVO> getList(@PathVariable("bno") Long bno) {
		List<ReplyVO> list = service.getList(bno);
		list.forEach(reply -> log.info(reply));
		return list;
	}
	 
}
