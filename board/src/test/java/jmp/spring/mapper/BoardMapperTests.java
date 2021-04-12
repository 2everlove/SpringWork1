package jmp.spring.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.controller.Test;
import jmp.spring.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@org.junit.Test
	public void insertTest() {
		BoardVO board = new BoardVO();
		
		board.setTitle("Test 제목");
		board.setContent("Test 내용");
		board.setWriter("Test 유저");
		
		boardMapper.insert(board);
	}
	
	@org.junit.Test
	public void deleteTest() {
		int count = boardMapper.delete(3L); //제거완료 ? 1..* :0
		log.info(count);
	}
}
