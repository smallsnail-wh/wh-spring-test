package com.wh.demo.test.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyTestListener {

	@EventListener
	public void testListenr(MyApplicationEvent event) {
		System.out.println("this is testListener1");
		System.out.println(event.toString());
		System.out.println("this is testListener2");
	}
	
}
