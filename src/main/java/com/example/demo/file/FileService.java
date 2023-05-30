package com.example.demo.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	 
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private String uploadDir;

	@Value("${user.home}")
	private String userHome;

	@PostConstruct
	public void init() {
		uploadDir = userHome + "/path/to/upload/directory";
	}

	public void fileUpload(MultipartFile file) throws Exception {
		Path savePath = Paths.get(uploadDir, cleanPath(file.getOriginalFilename()));
		
		try {
			Files.createDirectories(savePath.getParent()); // 부모 디렉토리 생성
			Files.copy(file.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error("fail to store file : name={}, exception={}", file.getOriginalFilename(), e.getMessage());
			throw new Exception("fail to store file");
		}
	}

	private String cleanPath(String filename) {
		String cleanedFilename = filename.replaceAll("[^a-zA-Z0-9.-]", "_");
		return cleanedFilename;
	}
}
