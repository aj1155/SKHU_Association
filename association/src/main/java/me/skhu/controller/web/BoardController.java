package me.skhu.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	@RequestMapping("list")
	public String list(){
		return "board/list";
	}

	@RequestMapping("read")
	public String read(){
		return "board/read";
	}

	@RequestMapping("write")
	public String write(){
		return "board/write";
	}

}