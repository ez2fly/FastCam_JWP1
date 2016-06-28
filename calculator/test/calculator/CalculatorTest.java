package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTest {

	Calculator calc;
	
	// 매번 Test 호출될 때마다 setup/teardown 이 각각 처음과 마지막에 호출된다. (별개의 인스턴스가 된다.)
	@Before
	public void setup(){					
		calc = new Calculator();
	}
	@After
	public void teardown(){				
		
	}
	
	@Test
	public void testAdd() {
		int n = calc.add(1, 3);
		assertEquals(4, n);
	}
	
	@Test
	public void testSub() throws Exception{
		int n = calc.sub(5,  1);
		assertEquals(4, n);
	}
	
	@Test
	public void testDivide() throws Exception{
		int n = calc.divide(9,  3);
		assertEquals(3, n);
	}
	
	
}
