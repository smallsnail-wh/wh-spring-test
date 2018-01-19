package com.wh.demo.test.async;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyTestListener {

	@EventListener(condition="#event.test == '123'")
	public void testListenr(MyApplicationEvent event) {
		System.out.println("this is testListener1");
		System.out.println(event.toString());
		System.out.println("this is testListener2");
	}
	
}
