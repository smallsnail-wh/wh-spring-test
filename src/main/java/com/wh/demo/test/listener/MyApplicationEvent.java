package com.wh.demo.test.listener;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent{

	private static final long serialVersionUID = -543396148689229096L;
	
	private final String address;
	
	public final String test;

	public MyApplicationEvent(Object source ,String address ,String test) {
		super(source);
		this.address = address;
		this.test = test;
	}

	@Override
	public String toString() {
		return "MyApplicationEvent [address=" + address + ", test=" + test + "]";
	}

}
