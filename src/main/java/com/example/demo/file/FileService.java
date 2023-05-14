package com.example.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.file.mapper.FileMapper;

@Service
public class FileService {
	
	@Autowired
	private FileMapper fileMapper;
	
	
}
