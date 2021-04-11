package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc; //가짜로 request를 보내줌
	
	@org.junit.Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}//method
	
	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(
						MockMvcRequestBuilders.get("/board/list")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap()
		);
	}//method
	
	@Test
	public void testRegister() throws Exception {
		log.info(
				mockMvc.perform(
						MockMvcRequestBuilders.post("/board/register")
						.param("title", "Test 테스트")
						.param("content", "Content")
						.param("writer", "user10")
						)
				.andReturn()
				);
	}//method
}
