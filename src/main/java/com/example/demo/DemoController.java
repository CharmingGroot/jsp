package com.example.demo;

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
	public String hello() {
		System.out.println("hello.");
		return "hello";
	}
	
	
	@RequestMapping("/base")
	public String base() {
		System.out.println("base....");
		return "base";
	}
	
}
