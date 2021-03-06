package jmp.spring.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import jmp.spring.mapper.timeMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OjdbcTest {
	
	  @Test 
	  public void testA() throws SQLException { 
		  long start = System.currentTimeMillis();
		  int i = 1; 
		  while(i<=100) {
			  Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "spring", "spring");
			/* System.out.println(i+"번 conn : "+conn); */ 
			  conn.close(); i++; 
		  } //while
		  long end = System.currentTimeMillis();
		  System.out.println("==ojdbc 총 소요시간 : "+(end-start)/1000.0+"s");
	  }//method()

	@Autowired
	HikariDataSource dateSource;
	@Autowired
	SqlSessionFactory factory;
	@Autowired
	timeMapper tm;
	
	@Test
	public void tmTest1() {
		System.out.println("==ql loading1 시간 : "+tm.getTime());
	}
	
	@Test
	public void tmTest2() {
		System.out.println("==ql loading2 시간 : "+tm.getTime2());
	}
	
	@Test
	public void sqlSessionFactoryTest() {
		SqlSession sqlSession = factory.openSession();
		Connection conn = sqlSession.getConnection();
		System.out.println("==sqlSession : "+conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void hikariTest() {
		long start = System.currentTimeMillis();
		for(int i = 1; i<=100; i++) {
			try {
				Connection conn = dateSource.getConnection();
				/* System.out.println(i+"번 conn : "+conn); */
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//for
		long end = System.currentTimeMillis();
		System.out.println("==hikari 총 소요시간 : "+(end-start)/1000.0+"s");
	}//method()
}//class
