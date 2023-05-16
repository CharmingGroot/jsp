package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.Page;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.mapper.BoardMapperImpl;
import com.example.demo.vo.Board;



@Controller
public class DemoController {

	@Autowired
	private BoardMapperImpl boardMapper;
	
	@RequestMapping("/")
	public String index() {
		System.out.println("hi");
		return "redirect:/index";
	}
	
	
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> formData = new HashMap<>();
		for(String paramName : request.getParameterMap().keySet()) {
			String paramValue = request.getParameter(paramName);
			formData.put(paramName, paramValue);
		}
		
//		System.out.println(formData.toString());
		for(String data : formData.keySet()) {
			System.out.println("name : "+data);
			System.out.println("value : "+formData.get(data));
			
			
		}
		System.out.println("hello.");
		return "hello";
	}
	
	
	@RequestMapping("/base")
	public String base() {
		System.out.println("base....");
		return "base";
	}
	
	

	@RequestMapping("/hello/file")
	public String file(HttpServletRequest request) {
//		System.out.println("file");
//		
//		Map formData = new HashMap<>();
//		for(String paramName : request.getParameterMap().keySet()) {
//			String paramValue = request.getParameter(paramName);
//			
//			formData.put(paramName, paramValue);
//		}
//		
//		System.out.println(formData.toString());
		
		
		
		
		return "fileinput";
	}
	
	
	
	
//    @GetMapping("/board/list")
//    public String boardList(Model model) {
//        List<Board> boardList = boardMapper.getAllBoards();
//        System.out.println(boardList);
//        model.addAttribute("boardList", boardList);
//        return "boardList";
//    }
	
	@GetMapping("/board/list")
	public String boardList(Model model, @RequestParam(defaultValue = "1") int page) {
	    int limit = 5; // 페이지당 게시글 수
	    int offset = (page - 1) * limit;
	    
	    List<Board> boardList = boardMapper.getBoardList(offset, limit);
	    int boardCount = boardMapper.getBoardCount();
	    
	    int totalPages = (int) Math.ceil((double) boardCount / limit);
	    
	    Page paging = new Page();
	    paging.setCurrentPage(page);
	    paging.setTotalPages(totalPages);
	    
	    model.addAttribute("boardList", boardList);
	    model.addAttribute("page", paging);
	    
	    return "boardList";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
