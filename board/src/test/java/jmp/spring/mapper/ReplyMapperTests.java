package jmp.spring.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void getTest() {
		log.info(mapper.get(6L));
	}
	
	@Test
	public void getListTest() {
		//List<ReplyVO> list = mapper.getList(203L);
		//log.info(list);
	}
	
	@Test
	public void insertTest() {
		ReplyVO rv = new ReplyVO();
		rv.setBno(203L);
		rv.setReply("제목11");
		rv.setReplyer("작성자");
		int res = mapper.insert(rv);
		log.info(mapper.insert(rv)+res);
	}
	
	@Test
	public void updateTest() {
		ReplyVO rv = new ReplyVO();
		rv.setRno(6L);
		rv.setReply("제목title");
		rv.setReplyer("작성자writer");
		rv.setUpdateDate("sysdate");
		log.info(mapper.update(rv));
	}
	
	@Test
	public void deleteTest() {
		log.info(mapper.delete(6L));
	}
	
	@Test
	public void getTotal() {
		log.info(mapper.getTotal(203L));
	}
}
