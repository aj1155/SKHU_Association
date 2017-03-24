package me.skhu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.skhu.domain.Introduce;
import me.skhu.domain.dto.AdminDto;
import me.skhu.service.AdminService;
import me.skhu.service.IntroduceService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private IntroduceService introduceService;

	@RequestMapping(value="adminSave", method = RequestMethod.GET)
	public String adminSave(Model model){
		AdminDto adminDto = new AdminDto();
		adminDto.setCategoryId(1);
		adminDto.setCategoryName("함께맞는빕");
		model.addAttribute("adminDto",adminDto);
		return "admin/save";
	}

	@RequestMapping(value = "adminSave" , method = RequestMethod.POST)
	public String adminSave(AdminDto adminDto){
		adminService.saveAdmin(adminDto);
		return "admin/save";
	}

	@RequestMapping(value = "introduceEdit", method = RequestMethod.GET)
	public String introduceEdit(Model model){
		model.addAttribute("introduce",introduceService.find());
		return "admin/introduceEdit";
	}

	@RequestMapping(value="introduceEdit", method = RequestMethod.POST)
	public String introduceEdit(Model model, Introduce introduce){
		introduceService.save(introduce);
		return "redirect:/admin/introduceEdit";
	}

	@RequestMapping(value="introduce",method = RequestMethod.GET)
	public String introduce(Model model){
		model.addAttribute("introduce",introduceService.find());
		return "admin/introduce";
	}

}