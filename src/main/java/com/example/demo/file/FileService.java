package com.example.demo.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${upload.dir}")
    private String uploadDir;

    public void fileUpload(MultipartFile file) throws Exception {
        String cleanFileName = cleanPath(file.getOriginalFilename());
        Path savePath = Path.of(uploadDir, cleanFileName);

        try {
            Files.createDirectories(savePath.getParent()); // 부모 디렉토리 생성
            Files.copy(file.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Failed to store file: name={}, exception={}", file.getOriginalFilename(), e.getMessage());
            throw new Exception("Failed to store file");
        }
    }

    private String cleanPath(String filename) {
        String cleanedFilename = filename.replaceAll("[^a-zA-Z0-9.-]", "_");
        return cleanedFilename;
    }
}
