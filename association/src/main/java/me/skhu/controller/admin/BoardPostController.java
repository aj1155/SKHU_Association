package me.skhu.controller.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.dto.BoardPostDto;
import me.skhu.service.BoardPostService;
import me.skhu.service.FileService;
import me.skhu.util.Pagination;

@Controller
@RequestMapping("boardpost")
public class BoardPostController {

	@Autowired
	private BoardPostService boardPostService;

	@Autowired
	private FileService fileService;

	@RequestMapping("list")
	public String list(Model model , Pagination pagination) {
		model.addAttribute("list", boardPostService.findAll(pagination,1));
		return "board/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model, Pagination pagination) {
		return "board/write";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute BoardPostDto boardPostDto,MultipartHttpServletRequest request, @RequestParam("file") MultipartFile[] files, Pagination pagination, BindingResult result) {
		try{
			if(!result.hasErrors())
				boardPostService.create(boardPostDto,files,request);
		}catch (Exception e){
			System.out.println("controller Error : " + e.getMessage());
		}
		return "board/list";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id , Model model, Pagination pagination){
    	model.addAttribute("boardPost",boardPostService.findById(id));
    	return "board/edit";
    }

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(BoardPostDto boardPostDto, Pagination pagination) throws UnsupportedEncodingException{
    	boardPostService.update(boardPostDto);
    	return "redirect:/boardpost/list";
    }

	@RequestMapping(value = "/read")
    public String read(@RequestParam("id") int id , Model model, Pagination pagination){
    	model.addAttribute("boardPost",boardPostService.findById(id));
    	model.addAttribute("fileList",fileService.findByBoardId(id));
    	return "board/read";
    }

	@RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id, Pagination pagination) throws UnsupportedEncodingException{
    	boardPostService.webDelete(id);
    	return "redirect:/boardpost/list";
    }

	@RequestMapping(value ="/download")
	public void download(@RequestParam("id") int id, HttpServletResponse response) throws IOException{
		fileService.download(id,response);
	}

}
