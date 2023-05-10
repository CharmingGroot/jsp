package com.example.demo.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FormDataController {
	
	@RequestMapping("/hello/request")
	public String helloReq(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> formData = new HashMap<>();
		for(String paramName : request.getParameterMap().keySet()) {
			String paramValue = request.getParameter(paramName);
			formData.put(paramName, paramValue);
		}
		
		System.out.println(formData.toString());
		
		System.out.println("hello.");
		return "redirect:/hello";
	}
	
		
}
