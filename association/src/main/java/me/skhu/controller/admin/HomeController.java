package me.skhu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.skhu.domain.dto.BoardDto;
import me.skhu.service.BoardService;

@Controller
public class HomeController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/home/login")
	public String home(){
		return "home/login";
	}

	@RequestMapping("/home/sideBar")
	public @ResponseBody List<BoardDto> sideBar(int categoryId){
		return boardService.findByCategoryId(categoryId);
	}
}
