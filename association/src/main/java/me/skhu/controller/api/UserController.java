package me.skhu.controller.api;

import me.skhu.controller.model.response.AsctApiResponse;
import me.skhu.controller.model.response.UserResponse;
import me.skhu.service.JwtTokenService;
import me.skhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @RequestMapping(value = {"/list/category/{categoryId}"},method = RequestMethod.GET)
    public AsctApiResponse<List<UserResponse>> readUserByCategoryId(@PathVariable String categoryId){
        List<UserResponse> list = this.userService.readUserByCategoryId(Integer.parseInt(categoryId));
        return new AsctApiResponse<>(list);
    }
}
