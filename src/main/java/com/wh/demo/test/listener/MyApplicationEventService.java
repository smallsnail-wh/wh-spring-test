package com.wh.demo.test.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationEventService implements ApplicationEventPublisherAware{

	private List<String> blackList;
    private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String text) {
    	blackList = new ArrayList<>();
    	blackList.add("known.spammer@example.org");
    	blackList.add("known.hacker@example.org");
    	blackList.add("john.doe@example.org");
        if (blackList.contains(address)) {
            publisher.publishEvent(new MyApplicationEvent(this, address, text));
            return;
        }
        // send email...
    }
    
    public void testListener(String address, String text) {
    	MyApplicationEvent event = new MyApplicationEvent(this, address, text);
        publisher.publishEvent(event);
    }

}
