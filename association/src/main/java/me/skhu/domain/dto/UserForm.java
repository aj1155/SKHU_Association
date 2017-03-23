package me.skhu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-03-22.
 */
@Getter
@Setter
public class UserForm {
    List<UserExcelDto> list;
}
