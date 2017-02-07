package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Files;

@Getter
@Setter
@Builder
public class FilesDto {

	private int boardId;
	private List<Files> files;

	public static FilesDto of(int boardId,List<Files> list){
		return FilesDto.builder()
				.boardId(boardId)
				.files(list)
				.build();
	}

}
