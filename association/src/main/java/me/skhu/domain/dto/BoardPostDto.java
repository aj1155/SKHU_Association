package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.BoardPost;
import org.joda.time.DateTime;

@Getter
@Setter
@Builder
public class BoardPostDto {

	private String title;
	private String content;
	private DateTime createTime;
	private DateTime modifiedTime;
	private String boardName;
	private String userName;

	public static BoardPostDto of(BoardPost boardPost){
		return BoardPostDto.builder()
				.title(boardPost.getTitle())
				.content(boardPost.getContent())
				.createTime(boardPost.getCreatedDate())
				.modifiedTime(boardPost.getLastModifiedDate())
				.build();
				/* Todo 객체를 담을지 필요할 때 가져올지 생각
				.boardName(boardPost.getBoard().getName())
				.userName(boardPost.getUser().getName())
				*/
	}
}
