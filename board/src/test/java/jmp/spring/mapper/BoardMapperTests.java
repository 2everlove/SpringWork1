package jmp.spring.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.domain.BoardVO;
import jmp.spring.domain.Criteria;
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
		int count = boardMapper.delete(14L); //제거완료 ? 1..* :0
		log.info(count);
	}
	
	@org.junit.Test
	public void selectTest() {
		BoardVO board = boardMapper.select(7L);
		log.info(board);
	}
	
	@Test
	public void getListTest() {
		List<BoardVO> list = boardMapper.getList();
		log.info(list);
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(11L);
		board.setTitle("수정된제목");
		board.setContent("수정된내용");
		board.setWriter("user00");
		int count = boardMapper.update(board);
		log.info("UPDATE COUNT : "+count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개씩 3페이지
		/*
		 * cri.setPageNum(3); cri.setAmount(10);
		 */
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
	
	@Test
	public void testGetTotal(Criteria cri) {
		log.info("Total : "+boardMapper.getTotal(cri));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("따뜻");
		cri.setType("TC");
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
