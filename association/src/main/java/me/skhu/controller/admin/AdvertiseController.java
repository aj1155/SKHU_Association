package me.skhu.controller.admin;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.dto.AdvertiseDto;
import me.skhu.service.AdvertiseCategoryService;
import me.skhu.service.AdvertiseService;
import me.skhu.service.UserService;
import me.skhu.util.Pagination;

@Controller
@RequestMapping("advertise")
public class AdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;

	@Autowired
	private AdvertiseCategoryService advertiseCategoryService;

	@Autowired
	private UserService userService;

	@RequestMapping("home")
	public String home(){
		return "advertise/home";
	}

	@RequestMapping("list")
	public String list(Model model,Pagination pagination,int categoryId){
		pagination.setPageSize(5);
		model.addAttribute("list",advertiseService.findAll(pagination,categoryId));
		return "advertise/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model,Pagination pagination){
		model.addAttribute("category",advertiseCategoryService.findAll());
		return "advertise/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model,AdvertiseDto advertiseDto, Pagination pagination,MultipartHttpServletRequest request, @RequestParam("image") MultipartFile file) throws ParseException{
		int category=advertiseService.create(advertiseDto,request,file);
		System.out.println("advertiseDto.content : "+advertiseDto.getContent());
		return "redirect:/advertise/list?categoryId="+category;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, Model model,Pagination pagination){
		model.addAttribute("advertiseDto",advertiseService.findById(id));
		return "advertise/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(AdvertiseDto advertiseDto,Pagination pagination){
		advertiseService.edit(advertiseDto);
		return "redirect:/advertise/list";
	}

	@RequestMapping(value = "deleted")
	public String deleted(@RequestParam("id") int id,Pagination pagination){
		advertiseService.deleted(id);
		return "redirect:/advertise/list";
	}

	@RequestMapping(value ="searchUser")
	public String searchUser(Model model, @RequestParam("name") String userName){
		model.addAttribute("list",userService.findByName(userName));
		return "commons/userList";
	}

}
