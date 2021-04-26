package jmp.spring.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.domain.BoardVO;
import jmp.spring.domain.ReplyVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapTest {
	
	@Test
	public void MapTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(202L);
		ReplyVO replyVO = new ReplyVO();
		replyVO.setRno(123L);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardVO", boardVO);
		map.put("replyVO", replyVO);
		
		log.info(map.toString());
		//키 값을 String으로 주었기에 꺼낼때도 String으로 꺼내야함
		log.info("boardVO :"+map.get("boardVO"));
		log.info("replyVO :"+map.get("replyVO"));
	}

}
