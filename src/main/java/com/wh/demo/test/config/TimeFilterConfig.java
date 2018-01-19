package com.wh.demo.test.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wh.demo.test.filter.TimeFilter;

//@Configuration
public class TimeFilterConfig {

	@Bean
	public FilterRegistrationBean<TimeFilter> timeFilter() {
		FilterRegistrationBean<TimeFilter> registrationBean = new FilterRegistrationBean<TimeFilter>();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}
	
}
