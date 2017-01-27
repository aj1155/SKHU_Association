package me.skhu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home/login")
	public String home(){
		return "home/login";
	}

}
