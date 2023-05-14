package com.example.demo.file;

import lombok.Data;

@Data
public class FileDto {

	private int id;
    private String fileName;
    private String filePath;
    private byte[] fileContent;
    private long fileSize;
	
}
