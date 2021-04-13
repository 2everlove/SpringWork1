package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServieceTests {
	
	@Autowired
	private BoardService service;
	
//	연결확인
	@Test
	public void testPrint() {
		log.info(service);
	}
	
//	목록조회
	@Test
	public void getList() {
		service.getList().forEach(board -> log.info(board));
	}
	
//	등록
	@Test
	public void testResister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Test 테스트");
		vo.setContent("Content 테스트");
		vo.setWriter("tester");
		
		long bno = service.register(vo);
		log.info("BNO : " +bno);
	}
}
