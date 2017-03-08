package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Board;
import me.skhu.domain.BoardImage;

/**
 * Created by iljun on 2017-03-03.
 */
@Getter
@Builder
@Setter
public class BoardImageDto {
    private int id;
    private String path;
    private int boardId;

    public static BoardImageDto of(BoardImage boardImage){
        return BoardImageDto.builder()
                .id(boardImage.getId())
                .path(boardImage.getPath())
                .boardId(boardImage.getBoardId())
                .build();
    }

    public static BoardImageDto of(String path, int boardId){
        return BoardImageDto.builder()
                .path(path)
                .boardId(boardId)
                .build();
    }
}
