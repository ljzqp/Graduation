package com.jxau.kknq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KknqApplicationTests {

	private static final long INFOLD_FLAG = 1517126919910L;
	@Test
	public void contextLoads() {
		long userId = System.currentTimeMillis() - INFOLD_FLAG;
//		System.out.println(System.currentTimeMillis()-1234);
		System.out.println(userId);
	}

}
