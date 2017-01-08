package me.skhu.controller.model.response;

import lombok.*;
import me.skhu.domain.TokenManager;


/**
 * Created by USER on 2017-01-06.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenManagerResponse {
    private TokenManager tokenManager;
}
