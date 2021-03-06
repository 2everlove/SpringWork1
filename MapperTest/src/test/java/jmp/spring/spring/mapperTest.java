package jmp.spring.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.timeMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class mapperTest {
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	timeMapper tm;
	
	@Test
	public void Test1() {
		SqlSession sqlSession = factory.openSession();
		System.out.println("==sqlSession : "+sqlSession.getConnection());
		System.out.println("==tm1 : "+tm.getTime());
		System.out.println("==tm2 : "+tm.getTime2());
	}
}
