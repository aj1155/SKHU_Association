package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Comment;

@Getter
@Setter
@Builder
public class CommentDto {
	private String userName;
	private String content;

	public static CommentDto of(Comment comment){
		return CommentDto.builder()
				.userName(comment.getUser().getName())
				.content(comment.getContent()).build();
	}
}
