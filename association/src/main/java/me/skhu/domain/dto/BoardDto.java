package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Board;

@Getter
@Setter
@Builder
public class BoardDto {

	private int boardType;

	private String name;
	private int categoryId;
	private String categoryName;

	public static BoardDto of(Board board){
		return BoardDto.builder()
				.boardType(board.getBoardType())
				.name(board.getName())
				.categoryId(board.getCategory().getId())
				.categoryName(board.getCategory().getName()).build();
	}
}
