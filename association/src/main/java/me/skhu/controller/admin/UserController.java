package me.skhu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.skhu.domain.dto.UserDto;
import me.skhu.service.UserService;
import me.skhu.util.Pagination;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(Model model, Pagination pagination){
		model.addAttribute("list", userService.list(pagination, 1));
		return "user/list";
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("userDto",userService.newUserDto());
		model.addAttribute("position",userService.getUserType());
		return "user/edit";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Model model, UserDto userDto){
		userService.create(userDto);
		//TODO: 한글저장안됨 UTF-8
		//TODO: 유저 생성시에 공개여부 테이블도 디폴트 비공개로 저장.
		return "redirect:/user/list";
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id, Pagination pagination){
		model.addAttribute("userDto", userService.findById(id));
		model.addAttribute("position", userService.getUserType());
		return "user/edit";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(Model model, @RequestParam("id") int id,UserDto userDto, Pagination pagination)throws Exception{
		userService.update(userDto,id);
		return "redirect:/user/list?"+pagination.getQueryString();
	}


}
