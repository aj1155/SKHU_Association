package me.skhu.controller.api;

import me.skhu.controller.model.request.UserRequest;
import me.skhu.controller.model.response.AsctApiResponse;
import me.skhu.controller.model.response.UserResponse;
import me.skhu.service.JwtTokenService;
import me.skhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    /***** create *****/
    //Todo response로 Json util 형태로 보내주기
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public AsctApiResponse<UserResponse> create(@Valid UserRequest userRequest){
        UserResponse user = userService.createUser(userRequest);
        return new AsctApiResponse<>(user);
    }

    /***** read *****/

    /* 카테고리별 user*/
    @RequestMapping(value = "/list/category/{categoryId}",method = RequestMethod.GET)
    public AsctApiResponse<List<UserResponse>> readUserByCategory(@PathVariable String categoryId){
        List<UserResponse> list = this.userService.readUserByCategoryId(Integer.parseInt(categoryId));
        return new AsctApiResponse<>(list);
    }

    /* 기수별 user*/
    @RequestMapping(value = "/list/category/{categoryId}/grade/{grade}",method = RequestMethod.GET)
    public AsctApiResponse<List<UserResponse>> readUserByGrade(@PathVariable String categoryId,@PathVariable String grade){
        List<UserResponse> list = this.userService.readUserByGrade(Integer.parseInt(categoryId),Integer.parseInt(grade));
        return new AsctApiResponse<>(list);
    }

    /* 기수별 임원 */
    @RequestMapping(value = "/manager/category/{categoryId}/grade/{grade}",method = RequestMethod.GET)
    public AsctApiResponse<List<UserResponse>> readManagerByGrade(@PathVariable String categoryId,@PathVariable String grade){
        List<UserResponse> list = this.userService.readManagerByGrade(Integer.parseInt(categoryId),Integer.parseInt(grade));
        return new AsctApiResponse<>(list);
    }

    /* 총동문 임원 */
    @RequestMapping(value = "/seniormanager/category/{categoryId}/grade/{grade}",method = RequestMethod.GET)
    public AsctApiResponse<List<UserResponse>> readSeniorManager(@PathVariable String categoryId,@PathVariable String grade){
        List<UserResponse> list = this.userService.readSeniorManager(Integer.parseInt(categoryId),Integer.parseInt(grade));
        return new AsctApiResponse<>(list);
    }

    /***** update *****/

    /* user 정보 업데이트 */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public AsctApiResponse<UserResponse> readSeniorManager(@Valid UserRequest userRequest){
        return this.userService.update(userRequest);
    }




}
