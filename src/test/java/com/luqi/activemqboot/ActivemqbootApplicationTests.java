package com.luqi.activemqboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqbootApplicationTests {

	@JmsListener(destination = "TestQ")
	@Test
	public void contextLoads(Object message) {
		System.out.println("receiveQueueMessage2:"+message);
	}

}
