package com.example.demo.file.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.file.FileDto;

import org.apache.ibatis.annotations.Many;

@Mapper
public interface  FileMapper {
	
    @Insert("INSERT INTO userfile(file_name, file_path, file_content, file_size) VALUES(#{fileName},#{filePath},#{fileContent},#{fileSize})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(FileDto fileDto);
    
	
}
