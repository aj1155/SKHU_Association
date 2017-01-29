package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.BoardPost;

@Getter
@Setter
@Builder
public class BoardPostListDto {
	List<BoardPost> boardPostList;

	public static BoardPostListDto of(List<BoardPost> boardPostList){
		return BoardPostListDto.builder()
				.boardPostList(boardPostList)
				.build();
	}
}
