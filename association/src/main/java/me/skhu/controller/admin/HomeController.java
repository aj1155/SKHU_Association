package me.skhu.controller.admin;

import java.util.List;


import me.skhu.config.security.SecurityAdminDetails;
import me.skhu.domain.AdvertiseCategory;
import me.skhu.domain.Board;
import me.skhu.domain.dto.AdvertiseCategoryDto;
import me.skhu.domain.dto.AdvertiseListDto;
import me.skhu.service.*;

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

    @Autowired
    private BoardPostService boardPostService;

    @Autowired
    private OriginUserPhoneService originUserPhoneService;

    @Autowired
    private OriginUserService originUserService;

    @RequestMapping("/menu/board")
    public @ResponseBody List<BoardDto> sideBar(){
        return boardService.findByCategoryId(adminService.getCurrentAdmin().getCategory().getId());
    }

    @RequestMapping("/menu/advertise")
    public @ResponseBody List<AdvertiseCategory> advertiseSideBar(){
        return advertiseCategoryService.findAll();
    }


    @RequestMapping("/menu/boarcCount")
    public @ResponseBody int sideBarBoardCount(){
        return boardPostService.findByCategoryCount(adminService.getCurrentAdmin().getCategory().getId());
    }

    @RequestMapping("/menu/phoneNumberEdit")
    public @ResponseBody int phoneNumberEdit(){
        return originUserPhoneService.findCount(adminService.getCurrentAdmin().getCategory().getId());
    }

    @RequestMapping("/menu/userEdit")
    public @ResponseBody int userEdit(){
        return originUserService.findCount(adminService.getCurrentAdmin().getCategory().getId());
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model){
    	return "home/login";
    }

}
