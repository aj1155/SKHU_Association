package me.skhu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.skhu.domain.AdvertiseCategory;
import me.skhu.domain.dto.BoardDto;
import me.skhu.service.AdminService;
import me.skhu.service.AdvertiseCategoryService;
import me.skhu.service.BoardService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdvertiseCategoryService advertiseCategoryService;

    @RequestMapping("/menu/board")
    public @ResponseBody List<BoardDto> sideBar(){
        return boardService.findByCategoryId(adminService.getCurrentAdmin().getCategory().getId());
    }

    @RequestMapping("/menu/advertise")
    public @ResponseBody List<AdvertiseCategory> advertiseSideBar(){
        return advertiseCategoryService.findAll();
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model){
    	return "home/login";
    }

}
