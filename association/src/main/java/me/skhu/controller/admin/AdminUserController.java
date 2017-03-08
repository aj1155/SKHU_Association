package me.skhu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.domain.dto.AdminDto;
import me.skhu.service.AdminUserService;
import me.skhu.service.CategoryService;
import me.skhu.service.MailService;
import me.skhu.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	AdminUserService adminUserService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	MailService mailService;

	@Autowired
	UserService userService;

	@RequestMapping("/myInfo")
	public String myInfo(Model model){
		//TODO: 로그인기능 이후 수정
		return "admin/myInfo";
	}

	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("list", adminUserService.list());
		return "admin/list";
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("adminDto", adminUserService.newAdminDto());
		model.addAttribute("category", categoryService.getCategory());
		return "admin/edit";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Model model, AdminDto adminDto){
		adminUserService.create(adminDto);
		return "redirect:/admin/list";
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model,@RequestParam("id") int id){
		model.addAttribute("adminDto", adminUserService.findById(id));
		model.addAttribute("category", categoryService.getCategory());
		return "admin/edit";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(Model model, @RequestParam("id") int id, AdminDto adminDto){
		adminUserService.update(adminDto,id);
		return "redirect:/admin/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id){
		adminUserService.delete(id);
		return "redirect:/admin/list";
	}

	@RequestMapping(value="/mailSend", method=RequestMethod.GET)
	public String mailSend(Model model){
		model.addAttribute("list", userService.list());
		return "admin/mailSend";
	}

	@RequestMapping(value="/searchUser", method=RequestMethod.POST)
	public String searchUser(Model model, @RequestParam("srchType") String srchType, @RequestParam("srchText") String srchText ){
		model.addAttribute("list", userService.getUserMail(srchType, srchText).getUser());
		return "admin/mailList";
	}

	@RequestMapping(value="/mailSend", method=RequestMethod.POST)
	public String mailSend(String sendTo, String mailSubject, String mailContent,@RequestParam("file") MultipartFile[] files){
		mailService.sendMailAddFile(sendTo, mailSubject, mailContent, files);
		return "admin/mailSend";
	}

}
