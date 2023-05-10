package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {

	@RequestMapping("/")
	public String index() {
		System.out.println("hi");
		return "redirect:/index";
	}
	
	
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> formData = new HashMap<>();
		for(String paramName : request.getParameterMap().keySet()) {
			String paramValue = request.getParameter(paramName);
			formData.put(paramName, paramValue);
		}
		
//		System.out.println(formData.toString());
		for(String data : formData.keySet()) {
			System.out.println("name : "+data);
			System.out.println("value : "+formData.get(data));
			
			
		}
		System.out.println("hello.");
		return "hello";
	}
	
	
	@RequestMapping("/base")
	public String base() {
		System.out.println("base....");
		return "base";
	}
	
}
