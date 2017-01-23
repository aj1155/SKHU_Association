package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Board;
import me.skhu.domain.BoardType;

@Getter
@Setter
@Builder
public class BoardDto {

	private BoardType boardType;
	private int categoryId;
	private String categoryName;

	public static BoardDto of(Board board){
		return BoardDto.builder()
				.boardType(board.getBoardType())
				.categoryId(board.getCategoryId())
				.build();
				/* Todo category Name 필요 여부 생각
				.categoryName(board.getCategory().getName())
				*/
	}
}
