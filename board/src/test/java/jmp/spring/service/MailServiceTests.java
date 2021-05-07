package jmp.spring.service;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MailServiceTests {
	
	@Autowired
	private Properties prop;
	
	@Autowired
	MailService ms;
	
	@Test
	public void test() {
		log.info("실행전");
		//메일전송 테스트
		ms.welcomeMailSend();
		log.info("실행후");
	}
	
	@Test
	public void rootTest() {
		log.info("======="+prop);
		log.info(prop.getProperty("mail.id"));
		
	}
}
