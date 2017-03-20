package me.skhu.util.Validator;

import me.skhu.domain.BoardPost;
import me.skhu.domain.dto.BoardPostInsertDto;
import me.skhu.util.Pagination;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by iljun on 2017-03-13.
 */
@Component
public class BoardPostValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz){
        return (BoardPostInsertDto.class.isAssignableFrom(clazz));
    }

    @Override
    public void validate(Object target , Errors errors){
        BoardPostInsertDto boardPost = (BoardPostInsertDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","filed.required");
    }

    public String errorMesage(BoardPostInsertDto boardPostInsertDto){
        if(StringUtils.isNullOrEmpty(boardPostInsertDto.getTitle()))
            return "제목을 입력해주세요.";
        if(StringUtils.isNullOrEmpty(boardPostInsertDto.getContent()))
            return "본문을 입력해주세요";
        return null;
    }
}
