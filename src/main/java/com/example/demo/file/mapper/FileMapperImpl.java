package com.example.demo.file.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.file.FileDto;

@Repository
public class FileMapperImpl implements FileMapper{

	@Autowired
	private SqlSession sqlSession;
	
    private static final String Namespace = "com.example.demo.file.mapper.FileMapper";

	
	@Override
	public int insert(FileDto fileDto) {
		System.out.println("insert 실행");
		
		
		return sqlSession.insert(Namespace + ".insert",fileDto);
	}
	
}
