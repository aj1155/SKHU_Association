package me.skhu.domain.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Created by iljun on 2017-03-03.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardPostInsertDto {
    @NotNull(message = "제목을 입력해주세요")
    @NotBlank(message = "제목을 입력해주세요")
    private String title;
    @NotNull(message = "본문을 입력하세요")
    @NotBlank(message = "본문을 입력하세요")
    private String content;
    private DateTime createTime;
    private DateTime modifiedTime;
    private int uesrId;
    private String userName;
    private int boardId;
}
