package test;

import org.testng.annotations.Test;

public class PS1 extends PS {

	@Test
	void testRun() {
		
		PS2 ps2 = new PS2(4);
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		
//		doThis();
	}
	
}
