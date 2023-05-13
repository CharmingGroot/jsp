package com.example.demo.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5
	)
@Controller
public class FormDataController {
	
	@RequestMapping("/hello/request/file")
	public String helloReq(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> formData = new HashMap<>();
		for(String paramName : request.getParameterMap().keySet()) {
			String paramValue = request.getParameter(paramName);
			formData.put(paramName, paramValue);
		}
		
		System.out.println(formData.toString());
		
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		
		
//		boolean hasFilePart = false;
//		String contentType = request.getContentType();
//		if (contentType != null && contentType.startsWith("multipart/form-data")) {
//		    try {
//		        Collection<Part> parts = request.getParts();
//		        for (Part part : parts) {
//		            if (part.getName().equals("file") && part.getSize() > 0) {
//		                hasFilePart = true;
//		                break;
//		            }
//		        }
//		    } catch (IOException | ServletException e) {
//		        // 예외 처리
//		    }
//		}

//		if(hasFilePart) {
//			Part filePart;
//			try {
//				filePart = request.getPart("file");
//				filePart.getInputStream();
//				System.out.println(filePart.getContentType());
//				System.out.println(filePart.toString());
//			} catch (IOException e) {
//				System.out.println("io예외발생");
//				e.printStackTrace();
//			} catch (ServletException e) {
//				System.out.println("서블릿 예외발생");
//				e.printStackTrace();
//			}
//		}
		
		Part filePart;
		try {
			filePart = request.getPart("file");
			filePart.getInputStream();
			System.out.println(filePart.getContentType());
			System.out.println(filePart.toString());
		} catch (IOException e) {
			System.out.println("io예외발생");
			e.printStackTrace();
		} catch (ServletException e) {
			System.out.println("서블릿 예외발생");
			e.printStackTrace();
		}
		
		
		
		
		
		

		return "redirect:/hello/file";
	}
	
		
}
