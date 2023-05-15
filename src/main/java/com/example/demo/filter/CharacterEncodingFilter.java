package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("before  filter");
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response); // 다음필터, 다음 서블릿 실행
		
		System.out.println("after filter");
		
	}

}
