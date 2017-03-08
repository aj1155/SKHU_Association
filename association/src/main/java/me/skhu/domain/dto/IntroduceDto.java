package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Introduce;

/**
 * Created by iljun on 2017-02-28.
 **/
@Getter
@Setter
@Builder
public class IntroduceDto {
    private String content;

    public static IntroduceDto of(Introduce introduce){
        return IntroduceDto.builder()
                .content(introduce.getContent())
                .build();
    }
}
