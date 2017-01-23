package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.File;

@Getter
@Setter
@Builder
public class FileDto {

	private int boardPostId;
	private String name;
	private String size;
	private String path;

	public static FileDto of(File file){
		return FileDto.builder()
				.boardPostId(file.getBoardPost().getId())
				.name(file.getName())
				.size(file.getSize())
				.path(file.getPath()).build();
	}
}
