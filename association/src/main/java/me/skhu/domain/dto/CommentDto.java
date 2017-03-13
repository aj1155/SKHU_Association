package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Comment;

import java.util.List;

@Getter
@Setter
@Builder
public class CommentDto {
	private List<Comment> list;

	public static CommentDto of(List<Comment> list){
		return CommentDto.builder()
				.list(list)
				.build();
	}
}