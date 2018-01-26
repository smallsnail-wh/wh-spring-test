package com.wh.demo.test.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletRequest request1 = request;
		Enumeration<String> s = request.getAttributeNames();
		/*if(StringUtils.equals(request.path, cs2)) {
			System.out.println("MyFilter处理");
		}*/
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter销毁");
	}

}
