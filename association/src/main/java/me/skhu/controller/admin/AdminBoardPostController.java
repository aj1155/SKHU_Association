package me.skhu.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.domain.dto.BoardPostDto;
import me.skhu.service.BoardPostService;

@Controller
@RequestMapping("boardpost")
public class AdminBoardPostController {

	@Autowired
	BoardPostService boardPostService;

	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list", boardPostService.findAll());
		return "board/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "board/write";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create1(Model model, BoardPostDto boardPostDto,@RequestParam("file") MultipartFile[] files) throws IOException{
    	boardPostService.create(boardPostDto,files);
    	return"board/list";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,Model model){
    	model.addAttribute("boardPost",boardPostService.findById(id));
    	return "board/write";
    }

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(BoardPostDto boardPostDto){
    	boardPostService.update(boardPostDto);
    	return "redirect:/boardpost/list";
    }

	@RequestMapping(value = "/read")
    public String read(@RequestParam("id") int id,Model model){
    	model.addAttribute("boardPost",boardPostService.findById(id));
    	return "board/read";
    }

	@RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id){
    	boardPostService.webDelete(id);
    	return "redirect:/boardpost/list";
    }

}
