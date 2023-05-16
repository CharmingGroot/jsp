package com.example.demo.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	@RequestMapping("/cookieImade")
	public String makeCookie(HttpServletRequest request, HttpServletResponse response) {
		
		String v = "a";
		String op = "b";
		
		// 쿠ㅋ심기
		Cookie valueCookie = new Cookie("value", v);
		Cookie opCookie = new Cookie("op", op);
	
		response.addCookie(valueCookie);
		response.addCookie(opCookie);
		
		
		
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		String _c = "";
		
		
		String x = "";
		
		for(Cookie c : cookies) {
			if(c.getName().equals(v)) {
				x = c.getValue();
				System.out.println(c.getValue());
				break;
			}
		}
		
		String operator = "";
		for(Cookie c : cookies) {
			if(c.getName().equals(op)) {
				operator = c.getValue();
				System.out.println(c.getValue());
				break;
			}
		}
		
		
		return "/cookie";
	}
	
}
