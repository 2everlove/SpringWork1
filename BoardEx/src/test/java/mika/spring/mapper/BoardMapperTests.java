package mika.spring.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import mika.spring.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_= @Autowired)
	BoardMapper mapper;
	
	@Test
	public void getListTest(){
		List<BoardVO> list = mapper.getList();
		log.info(list);
	}
	
	@Test
	public void insertTest() {
		BoardVO board = new BoardVO();
		board.setContent("언제가지...");
		board.setTitle("으으으");
		board.setWriter("ㅇㅂㅇ");
		log.info(mapper.insert(board));
	}
	
	@Test
	public void getBoardTest() {
		BoardVO board = mapper.getBoard(246L);
		
		log.info(board);
	}
}
