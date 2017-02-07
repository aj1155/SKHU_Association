package me.skhu.domain.dto;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skhu.domain.BoardPost;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostDto {
	private int id;
	private String title;
	private String content;
	private DateTime createTime;
	private DateTime modifiedTime;
	private String boardName;
	private String userName;
	private int userId;

	public static BoardPostDto of(BoardPost boardPost){
		return BoardPostDto.builder()
				.id(boardPost.getId())
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
