package com.example.demo.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Board {
	private int id;
    private String title;
    private String content;
    private String author;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
