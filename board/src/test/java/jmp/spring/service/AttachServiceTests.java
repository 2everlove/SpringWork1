package jmp.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.domain.AttachFileVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AttachServiceTests {

	@Setter(onMethod_= @Autowired)
	private AttachService service;
	
	@Test
	public void getSeqTest() {
		log.info(service.getSeq());
	}
	
	@Test
	public void insertTest() {
		AttachFileVO attachFileVO = new AttachFileVO();
		attachFileVO.setAttachNo(2L);
		attachFileVO.setFileName("name");
		attachFileVO.setFiletype("n");
		attachFileVO.setUploadPath("c:\\");
		attachFileVO.setUuid("n");
		log.info(service.insert(attachFileVO));
	}
	
	@Test
	public void getList() {
		log.info(service.getList(1L));
	}
}
