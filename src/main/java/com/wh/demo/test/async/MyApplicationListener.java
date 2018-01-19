package com.wh.demo.test.async;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent>{

    public void onApplicationEvent(MyApplicationEvent event) {
    	System.out.println("this is my listener1");
    	System.out.println(event.toString());
    	System.out.println("this is my listener2");
    }

}
