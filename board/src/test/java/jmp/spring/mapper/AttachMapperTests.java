package jmp.spring.mapper;

import java.util.List;

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
public class AttachMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private AttachMapper mapper;
	
	@Test
	public void getList() {
		List<AttachFileVO> list = mapper.getList(1L);
		log.info(list);
	}
	
	@Test
	public void getSeqTest() {
		log.info(mapper.getSeq());
	}
	
	@Test
	public void insertTest() {
		AttachFileVO attachFileVO = new AttachFileVO();
		attachFileVO.setAttachNo(1L);
		attachFileVO.setFileName("name");
		attachFileVO.setFiletype("n");
		attachFileVO.setUploadPath("c:\\");
		attachFileVO.setUuid("sadf");
		mapper.insert(attachFileVO);
	}
}
