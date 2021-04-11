package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일을 읽기 위해
@Log4j
public class SampleTests {
	
	@Autowired
	private Restraunt restraunt;
	
	@Autowired//spring 상(context 영역)에 SampleHotel 객체가 있으면 주입
	private SampleHotel hotel;
	
	@Test
	public void testHotel1() {
		log.info(hotel);
	}
	
	@Test
	public void test11() {
		System.out.println("test1.........");
		log.info("test1.........");
		log.info(restraunt);
	}
}
