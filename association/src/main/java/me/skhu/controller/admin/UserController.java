package me.skhu.controller.admin;

import me.skhu.domain.OriginUser;
import me.skhu.domain.dto.OriginUserDto;
import me.skhu.service.OriginUserPhoneService;
import me.skhu.service.OriginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.skhu.domain.dto.UserDto;
import me.skhu.service.UserService;
import me.skhu.util.Pagination;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private OriginUserService originUserService;

	@Autowired
	private OriginUserPhoneService originUserPhoneSerice;

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

	@RequestMapping(value="userEditList", method=RequestMethod.GET)
	public String userEditList (Model model, Pagination pagination){
		model.addAttribute("userEditList",userService.getEditUser(pagination));
		return "user/userEditList";
	}

	@RequestMapping(value = "/userEditAgree" , method=RequestMethod.GET)
	@ResponseBody
	public void userEditAgree(@RequestParam(value="checkList[]") List<String> checked){
		System.out.println("checkList[] : " + checked);
		System.out.println("checked[0]: " + checked.get(0));
		System.out.println("checked[1]: " + checked.get(1).toString());
	}

	@RequestMapping(value="userEditDetail", method = RequestMethod.GET)
	public String userEditDetails(Model model, @RequestParam("id") int id){
		OriginUserDto originUser = originUserService.findById(id);
		model.addAttribute("originUser",originUser);
		model.addAttribute("user",userService.findById(originUser.getUserId()));
		return "user/userEditDetail";
	}

	@RequestMapping(value = "phoneNumberEditList", method = RequestMethod.GET)
	public String phoneNumberEditList(Model model, Pagination pagination){
		model.addAttribute("list",originUserPhoneSerice.pagination(pagination));
		return "user/phoneNumberEditList";
	}

	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public @ResponseBody String agree(@RequestParam("id") int id){
		try{
			originUserPhoneSerice.agree(id);
			return "success";
		}catch (Exception e){
			return "false";
		}

	}

	@RequestMapping(value="agrees", method = RequestMethod.GET)
	public @ResponseBody String agrees(@RequestParam(value = "id" , required = true) List<Integer> id){
		try{
			originUserPhoneSerice.agrees(id);
			return "success";
		}catch (Exception e){
			return "fail";
		}
	}
}
