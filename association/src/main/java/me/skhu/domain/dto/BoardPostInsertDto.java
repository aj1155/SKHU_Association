package me.skhu.domain.dto;

import lombok.*;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Created by iljun on 2017-03-03.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardPostInsertDto {
    private String title;
    private String content;
    private DateTime createTime;
    private DateTime modifiedTime;
    private int uesrId;
    private String userName;
    private int boardId;
}
