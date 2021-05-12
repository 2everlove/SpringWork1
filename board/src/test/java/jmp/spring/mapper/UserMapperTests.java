package jmp.spring.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.domain.User;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserMapperTests {

	@Autowired
	UserMapper mapper;
	
	@Test
	public void login() {
		User user = new User();
		user.setId("user01");
		user.setPwd("1234");
		log.info(mapper.login(user));
	}
	@Test
	public void roleTest() {
		log.info(mapper.getRole("user01"));
	}
	
	@Test
	public void sessionkeyTest() {
		User user = new User();
		user.setId("user01");
		user.setPwd("1234");
		log.info(mapper.updateSessionkey(user));
	}
	
	@Test
	public void loginSessionkeyTest() {
		String sessionkey = "B858BFAC4F2B9CA72D3B31172CC159DC";
		User user = mapper.loginSessionkey(sessionkey);
		log.info(user);
	}
}
