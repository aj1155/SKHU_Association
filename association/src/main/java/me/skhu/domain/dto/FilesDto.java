package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Files;

@Getter
@Setter
@Builder
public class FilesDto {

	private int boardPostId;
	private String name;
	private Long size;
	private String path;

	public static FilesDto of(Files file){
		return FilesDto.builder()
				.boardPostId(file.getBoardId())
				.name(file.getName())
				.size(file.getSize())
				.path(file.getPath()).build();
	}

}
