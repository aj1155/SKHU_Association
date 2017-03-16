package me.skhu.util.Validator;

import me.skhu.domain.BoardPost;
import me.skhu.domain.dto.BoardPostDto;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by iljun on 2017-03-14.
 */
@Component
public class BoardPostEditValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz){
        return BoardPostDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        BoardPostDto boardPost = (BoardPostDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"content","content");
    }

    public String errorMessage(BoardPostDto boardPost){
        if(StringUtils.isNullOrEmpty(boardPost.getTitle()))
            return "제목을 입력해주세요.";
        if(StringUtils.isNullOrEmpty(boardPost.getContent()))
            return "본문을 입력해주세요.";
        return null;
    }
}
