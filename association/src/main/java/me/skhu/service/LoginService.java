package me.skhu.service;


import me.skhu.controller.model.request.TokenManagerRequest;
import me.skhu.controller.model.response.TokenManagerResponse;
import me.skhu.domain.TokenManager;
import me.skhu.repository.TokenManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by USER on 2017-01-07.
 */
@Service
public class LoginService {

    @Autowired
    TokenManagerRepository tokenManagerRepository;

    public TokenManagerResponse loginProcessing(TokenManagerRequest tokenManagerRequest){
        TokenManager tokenManager = new TokenManager(tokenManagerRequest);
        if(tokenManagerRepository.findByFacebookId(tokenManagerRequest.getFacebookId())==null){
            TokenManager tk = new TokenManager(tokenManagerRequest);
            tokenManagerRepository.save(tk);
        }else{
            tokenManagerRepository.setFixedTokenFor(tokenManagerRequest.getToken(),tokenManagerRequest.getFacebookId());
        }
        TokenManagerResponse tokenManagerResponse = new TokenManagerResponse();
        tokenManagerResponse.setTokenManager(tokenManager);
        return tokenManagerResponse;

    }
}
