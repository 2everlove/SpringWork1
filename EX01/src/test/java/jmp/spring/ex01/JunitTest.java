package jmp.spring.ex01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class JunitTest {
	int index;
	int[] result = new int[3];
	String[] ex = {"2","1","str"};
	@Test
	public void testA() {
		Calculator cal = new Calculator();
		int res = cal.calculator("1","1","+");
		result[index++] = res;
	}
	@Test
	public void testB() {
		Calculator cal = new Calculator();
		int res = cal.calculator("1","1","+");
		result[index++] = res;
	}
	@Test
	public void testTotal() {
		Calculator cal = new Calculator();

		int res = cal.calculator("1","1","+");
		result[index++] = res;
		
		for(int i = 0; i<index; i++) {
			System.out.print(ex[index] +" : "+ result[index] + ", ");
			assertEquals(ex[index], result[index]);
		}
	}
	
	@Test
	public void testD() {
		Calculator cal = new Calculator();
		
		String[] str = {"1","2","Str"};
		
		for(String value : str) {
			System.out.println(value);
			int res = cal.calculator(value,"1","+");
			System.out.println(res);
			assertEquals(1,res);
		}
		
	}
	
	
}
