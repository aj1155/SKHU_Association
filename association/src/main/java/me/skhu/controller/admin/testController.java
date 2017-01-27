package me.skhu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.skhu.domain.dto.AdminDto;
import me.skhu.service.AdminService;

@RestController
public class testController {

	@Autowired
	AdminService adminService;
		@RequestMapping("/test")
		public AdminDto test(){
			AdminDto admin = adminService.findByLoginId("test");
			return admin;
		}
}
