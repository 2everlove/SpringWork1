package jmp.spring.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;

import lombok.extern.log4j.Log4j;

/*@RunWith(SpringJUnit4ClassRunner.class)
@contextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")*/
@Log4j
public class OjdbcTest {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "spring";
	private static String password = "spring";
	private static Connection conn = null;
	
	@Test
	public void testConn() {
		long start = System.currentTimeMillis();
		for(int i=1; i<=100; i++) {
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.print(i+"번 conn: "+conn+", ");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(!conn.isClosed()) {
						conn.close();	
						System.out.println("conn 연결종료");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//for
		long end = System.currentTimeMillis();
		System.out.println("총 소요시간 : "+(end-start)/1000.0+"s");
	}//method
	
	
	/*
	 * // 오류처리및 소스 정리를 해봅시다.
	 * 
	 * @Test public void testConnection(){
	 * 
	 * Connection con = null;
	 * 
	 * // 시간을 찍기위한 변수 long start = System.currentTimeMillis();
	 * 
	 * // 클래스 로드 try { Class.forName("oracle.jdbc.driver.OracleDriver"); con =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
	 * "spring","spring"); log.info(con);
	 * 
	 * con.close();
	 * 
	 * long end = System.currentTimeMillis();
	 * System.out.println((end-start)/1000+"s"); } catch (Exception e) {
	 * e.getMessage(); } }//method(()
	 */
}//class
