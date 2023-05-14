package com.example.demo.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.file.FileDto;
import com.example.demo.file.mapper.FileMapper;
import com.example.demo.file.mapper.FileMapperImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5
	)
@Controller
public class FormDataController {
	
	@Autowired
	private FileMapperImpl fileMapper;
	
	@RequestMapping("/hello/request/file")
	public String helloReq(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Map<String,String> formData = new HashMap<>();
		for(String paramName : request.getParameterMap().keySet()) {
			String paramValue = request.getParameter(paramName);
			formData.put(paramName, paramValue);
		}
		
		System.out.println(formData.toString());
		
		// 파일이 저장될 경로 설정
		String realPath = request.getServletContext().getRealPath("");
		String savePath = realPath + File.separator + "uploadFiles";

        
        // 업로드된 파일을 저장할 디렉토리 생성
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        // 파일 파트를 읽어들임
        Part filePart = request.getPart("file");
        System.out.println(filePart);
        
        // 파일 이름 추출
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        System.out.println(fileName);
        
        
        // 파일 저장 경로 지정
        String filePath = savePath + File.separator + fileName;
        System.out.println(filePath);
       
        


        
        try (InputStream inputStream = filePart.getInputStream()) {
            byte[] fileContent = inputStream.readAllBytes();
            long fileSize = filePart.getSize();
            
            FileDto fileDto = new FileDto();
            fileDto.setFileName(fileName);
            fileDto.setFilePath(filePath);
            fileDto.setFileContent(fileContent);
            fileDto.setFileSize(fileSize);
            
            System.out.println("이름"+fileDto.getFileName());
            System.out.println("경로"+fileDto.getFilePath());
            System.out.println("사이즈"+fileDto.getFileSize());
            System.out.println("아이디"+fileDto.getId());
            System.out.println("콘텐츠"+fileDto.getFileContent());
            
            Files.copy(inputStream, Paths.get(filePath));
            fileMapper.insert(fileDto);
            System.out.println("fileMapper : "+fileMapper);
            
                   
        }

		
  

		return "redirect:/hello/file";
	}
	
		
}
