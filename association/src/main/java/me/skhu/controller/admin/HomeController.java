package me.skhu.controller.admin;

import java.util.List;

import me.skhu.config.security.SecurityAdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.skhu.domain.dto.BoardDto;
import me.skhu.service.BoardService;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index page<br/><a href=/mypage>mypage</a>";
    }

    @RequestMapping("mypage")
    public String mypage(@AuthenticationPrincipal SecurityAdminDetails adminDetails){
        return "us myPage</br>"+adminDetails.getLoginId()+"<br/><a href=/logout>logout</a>";
    }
}
