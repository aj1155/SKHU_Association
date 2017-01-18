package me.skhu.controller.admin;


import me.skhu.controller.model.request.TokenManagerRequest;
import me.skhu.controller.model.response.AsctApiResponse;
import me.skhu.controller.model.response.TokenManagerResponse;
import me.skhu.repository.TokenManagerRepository;
import me.skhu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by USER on 2017-01-06.
 */
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    TokenManagerRepository tokenManagerRepository;

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public AsctApiResponse<TokenManagerResponse> loginProcess(@Valid @RequestBody TokenManagerRequest tokenManagerRequest)  {
        return new AsctApiResponse(loginService.loginProcessing(tokenManagerRequest));
    }
}
