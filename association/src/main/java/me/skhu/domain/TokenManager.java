package me.skhu.domain;

import lombok.Getter;
import lombok.Setter;
import me.skhu.controller.model.request.TokenManagerRequest;

import javax.persistence.*;

/**
 * Created by USER on 2017-01-06.
 */
@Entity
@Getter
@Setter
public class TokenManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column
    private String facebookId;

    @Column
    private String token;

    public TokenManager(TokenManagerRequest tokenManagerRequest){
        this.facebookId = tokenManagerRequest.getFacebookId();
        this.token = tokenManagerRequest.getToken();
    }
}
