package me.skhu.controller.model.response;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.BoardPost;
import me.skhu.domain.Comment;

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
    private Collection<Comment> commentList;

    public static BoardPostResponse ofBoard(BoardPost boardPost){
        return BoardPostResponse.builder()
                .title(boardPost.getTitle())
                .content(boardPost.getContent())
                .writer_name(boardPost.getWriter_name())
                .commentList(boardPost.getCommentList())
                .build();
    }
}
