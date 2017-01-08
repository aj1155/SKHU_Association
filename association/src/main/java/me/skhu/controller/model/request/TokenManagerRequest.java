package me.skhu.controller.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Created by USER on 2017-01-06.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TokenManagerRequest {
    private Long id;
    @NotNull
    private String facebookId;
    @NotNull
    private String token;


}
