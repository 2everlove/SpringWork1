package jmp.spring.service;

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
public class ReplyServiceTests {

	@Setter(onMethod_= {@Autowired})
	private ReplyService service;
	
	@Test
	public void getTest() {
		log.info(service.get(6L));
	}
	
	@Test
	public void getListTest() {
		log.info(service.getList(203L));
	}
	
	@Test
	public void insertTest() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(203L);
		reply.setReply("댓글이  dal고 시퍼");
		reply.setReplyer("댓글rer");
		log.info(service.insert(reply));
	}
	
	@Test
	public void updateTest() {
		ReplyVO reply = new ReplyVO();
		reply.setRno(23L);
		reply.setReply("dal고나");
		reply.setReplyer("reply어");
		log.info(service.update(reply));
	}
	
	@Test
	public void deleteTest() {
		log.info(service.delete(22L));
	}
	
	@Test
	public void getTotal() {
		log.info(service.getTotal(203L));
	}
	
}
