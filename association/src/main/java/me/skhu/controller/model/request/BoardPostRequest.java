package me.skhu.controller.model.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@Getter
@Setter
public class BoardPostRequest {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String writer_name;
    @NotNull
    private int writer_id;
    @NotNull
    private int ownBoardId;

}
