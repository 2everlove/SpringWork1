package jmp.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.domain.Criteria;
import jmp.spring.domain.PageDTO;
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
	
	@GetMapping("/get/{rno}")
	public ReplyVO get(@PathVariable("rno") Long rno) {
		log.info("get.........."+rno);
		ReplyVO reply = service.get(rno);
		return reply; 
	}
	
	//board.bno에 해당하는 list불러옴
	@GetMapping("/list/{bno}/{pageNum}")
	public Map<String, Object> getList(@PathVariable("bno") Long bno, @PathVariable("pageNum") int pageNum) {
		log.info("list........");
		Criteria cri = new Criteria(1, 10);
		
		//page process
		PageDTO page = new PageDTO(cri, service.getTotal(bno));
		
		//List process
		List<ReplyVO> list = service.getList(bno);
		list.forEach(reply -> log.info(reply));
		
		//결과를 map에 담아서 return
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pageNum", page);
		map.put("list", list);
		
		return map;
	}//
	
	@PostMapping("/insert")
	public Map<String, Object> insert(@RequestBody ReplyVO reply) {
		System.out.println("ddddddd");
		log.info("insert......");
		int res = service.insert(reply);
		
		log.info("insert : "+reply+"\nresult : "+(res==1?"success":"fail"));
		service.getList(reply.getBno()).forEach(r -> log.info(r));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(res > 0)
			map.put("result", "success");
		else
			map.put("result", "fail");
		
		return map;
	}//
	
	@GetMapping("/delete/{rno}")
	public Map<String, String> delete(@PathVariable("rno") Long rno) {
		
		log.info("delete.........");
		
		int res = service.delete(rno);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(res>0)
			map.put("result","success");
		else
			map.put("result","fail");
		
		return map;
	}//
	
	//@param vo
	//@return 업데이트 결과 Map<String, String>
	//post방식이라서 url로 테스트 할 수 없음
	@PostMapping("/update")
	public Map<String, String> update(@RequestBody ReplyVO reply) {
		log.info("update.........");
		int res = service.update(reply);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(res>0)
			map.put("result","success");
		else
			map.put("result","fail");
		
		return map;
	}
	 
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
}//class
