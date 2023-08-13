package com.example.demo;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainWebController {

	
	@RequestMapping("/")
	public String index() {
		
		
		log.info("index");
		
		
		return "/index";
	}
	
}
