package me.skhu.domain.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.BoardPost;

@Getter
@Setter
@Builder
public class BoardPostDto {

	private String title;
	private String content;
	private Date createTime;
	private Date modifiedTime;
	private String boardName;
	private String userName;

	public static BoardPostDto of(BoardPost boardPost){
		return BoardPostDto.builder()
				.title(boardPost.getTitle())
				.content(boardPost.getContent())
				.createTime(boardPost.getCreateTime())
				.modifiedTime(boardPost.getModifiedTime())
				.boardName(boardPost.getBoard().getName())
				.userName(boardPost.getUser().getName()).build();
	}
}
