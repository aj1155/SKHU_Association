package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserExcelDto {
	private List<UserDto> list;

	public static UserExcelDto of(List<UserDto> list){
		return UserExcelDto.builder()
				.list(list)
				.build();
	}
}
