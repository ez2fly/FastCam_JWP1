package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	StringCalculator scalc;

	@Before
    public void Setup(){
		scalc = new StringCalculator();
	}
	
	
	@Test
	public void testAdd_null() throws Exception  {
		assertEquals(0, scalc.add(null));
		assertEquals(0, scalc.add(""));
	}

	@Test
	public void testAdd_onenum() throws Exception {
		int sum = scalc.add("1");
		assertEquals(1, sum);
	}
	
	@Test
	public void testAdd_twonum() throws Exception {
		int sum = scalc.add("1,2");
		assertEquals(3, sum);
	}
	
	@Test
	public void testAdd_threenum() throws Exception {
		int sum = scalc.add("1,2,3");
		assertEquals(6, sum);
	}
	
	@Test
	public void testAdd_newline() throws Exception {
		int sum = scalc.add("1,2\n3");
		assertEquals(6, sum);
	}
	
	@Test
	public void testAdd_colone() throws Exception {
		int sum = scalc.add("1,2:3");
		assertEquals(6, sum);	
	}
	
	@Test
	public void testAdd_custom() throws Exception {
		int sum = scalc.add("//;\n1;2;3");
		assertEquals(6, sum);	
	}
	
	@Test(expected=RuntimeException.class)
	public void testAdd_exception() throws Exception {
	    
	    assertEquals(4, scalc.add("-1, 2, 3"));
	}
}
