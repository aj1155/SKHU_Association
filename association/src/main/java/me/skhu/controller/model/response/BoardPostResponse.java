package me.skhu.controller.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.BoardPost;
import me.skhu.domain.Comment;

import java.util.List;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@Getter
@Setter
@Builder
public class BoardPostResponse {

    private String title;
    private String content;
    private String writer_name;
    private List<Comment> commentList;

    public static BoardPostResponse ofBoard(BoardPost boardPost){
        return BoardPostResponse.builder()
                .title(boardPost.getTitle())
                .content(boardPost.getContent())
                .writer_name(boardPost.getWriter_name())
                .commentList(boardPost.getCommentList())
                .build();
    }
}