package me.skhu.controller.admin;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.domain.dto.UserDto;
import me.skhu.service.PositionService;
import me.skhu.service.UserService;
import me.skhu.util.PaginationUser;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PositionService positionService;

	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute("pagination") PaginationUser pagination){
		//TODO: categoryId 도 넣을 것
		model.addAttribute("position", positionService.getUserType());
		model.addAttribute("list",userService.list(pagination));
		return "user/list";
	}

	@RequestMapping(value="/list", method=RequestMethod.POST, params="cmd=delete")
	public String deleteUser(Model model, @ModelAttribute("pagination") PaginationUser pagination, String[] del)throws Exception{
		userService.delete(del);
		return "redirect:/user/list?"+pagination.getQueryString();
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("userDto",userService.newUserDto());
		model.addAttribute("position", positionService.getUserType());
		return "user/edit";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST, params="cmd=save")
	public String create(Model model, UserDto userDto){
		userService.create(userDto);
		return "redirect:/user/list";
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id, @ModelAttribute("pagination") PaginationUser pagination, HttpServletRequest request){
		String imgPath="/resources/upload/profileImg/"+id+"_img.png";
		File file = new File(request.getSession().getServletContext().getRealPath("/")+imgPath);
		if(!file.exists())
			imgPath = "/resources/upload/profileImg/user.png";
		model.addAttribute("imgPath", imgPath);
		model.addAttribute("userDto", userService.findById(id));
		model.addAttribute("position", positionService.getUserType());
		return "user/edit";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="cmd=save")
	public String edit(Model model, @RequestParam("id") int id, UserDto userDto, @ModelAttribute("pagination") PaginationUser pagination)throws Exception{
		userService.update(userDto,id);
		return "redirect:/user/list?"+pagination.getQueryString();
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="cmd=delete")
	public String deleteOne(Model model, @RequestParam("id") int id, UserDto userDto, @ModelAttribute("pagination") PaginationUser pagination)throws Exception{
		userService.deleteOne(id);
		return "redirect:/user/list?"+pagination.getQueryString();
	}

	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String imageTest(Model model,@RequestParam("id") int id, @RequestParam("cma_file") MultipartFile uploadFile, HttpServletRequest request) throws Exception{
		userService.saveImg(request.getServletContext().getRealPath("/"),id,uploadFile);
		return "redirect:/user/edit?id="+id;
	}

	@RequestMapping("/typeList")
	public String list(Model model){
		model.addAttribute("list", positionService.getUserType());
		return "user/typeList";
	}


	@RequestMapping(value="/createType", method=RequestMethod.GET)
	public String createType(Model model){
		return "user/createType";
	}

	@RequestMapping(value="/createType", method=RequestMethod.POST)
	public String createType(String type, String name){
		positionService.createType(type,name);
		return "redirect:/user/typeList";
	}

}
