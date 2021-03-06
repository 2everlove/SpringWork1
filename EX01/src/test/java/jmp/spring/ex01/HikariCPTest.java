package jmp.spring.ex01;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HikariCPTest {
	/*
	 * private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	 * private static String username = "spring"; 
	 * private static String password = "spring";
	 */

	@Autowired
	HikariDataSource dateSource;
	
	@Test
	public void testConn() {
		long start = System.currentTimeMillis();
		for(int i=1; i<=100; i++) {
			try(Connection conn = dateSource.getConnection();) {
				
				System.out.print(i+"번 conn : "+conn+", ");
				
				conn.close();
				System.out.println("conn 연결종료");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}//for
		long end = System.currentTimeMillis();
		System.out.println("총 소요시간 : "+(end-start)/1000.0+"s");
	}
}
