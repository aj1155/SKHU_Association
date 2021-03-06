package me.skhu.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.skhu.controller.model.request.UserRequest;
import me.skhu.domain.User;
import me.skhu.repository.UserRepository;

/**
 * Created by Manki Kim on 2017-01-19.
 */
@Service
public class JwtTokenService {

    @Autowired
    private UserRepository userRepository;

    // default 7 days
    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

    public Map<String,Object> createJWT(UserRequest userRequest){
        String token = generateToken(generateClaims(userRequest));
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("token",token);
        if(token!=null && !token.isEmpty()){
            response.put("status",200);
            response.put("msg","Ok");
        }else{
            response.put("msg","인증 실패");
            response.put("status",1000);
        }
        return response;
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            username = (String) claims.get("user_name");
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + this.expiration * 1000);
    }

    private Map<String,Object> generateClaims(UserRequest userRequest){
        User user = loginPassingDo(userRequest);
        if(user == null) return null;

        Map<String,Object> userClaims = new HashMap<String,Object>();
        userClaims.put("user_id",user.getId());
        userClaims.put("user_name",user.getName());
        userClaims.put("image",user.getImage());


        return userClaims;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private User loginPassingDo(UserRequest userRequest){
        User user = this.userRepository.findByLoginIdAndPassword(userRequest.getLogin_id(),userRequest.getPassword());
        return (user==null)? null:user;
    }
}
