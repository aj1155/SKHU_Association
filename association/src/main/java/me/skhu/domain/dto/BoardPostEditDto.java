package me.skhu.domain.dto;

import lombok.*;
import me.skhu.domain.Files;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by iljun on 2017-02-13.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostEditDto {
    private int id;
    private String title;
    private String content;
    private List<Files> files;
    private DateTime modifiedTime;
    private String boardName;
    private String userName;
    private int userId;

    public static BoardPostEditDto of(BoardPostDto boardPostDto, List<Files> file){
        return BoardPostEditDto.builder()
                .id(boardPostDto.getId())
                .title(boardPostDto.getTitle())
                .content(boardPostDto.getContent())
                .files(file)
                .modifiedTime(boardPostDto.getModifiedTime())
                .boardName(boardPostDto.getBoardName())
                .userName(boardPostDto.getUserName())
                .userId(boardPostDto.getUserId())
                .build();
    }
}
