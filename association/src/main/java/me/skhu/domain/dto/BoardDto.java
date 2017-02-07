package me.skhu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skhu.domain.Board;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

	private String boardType;
	private int categoryId;

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
