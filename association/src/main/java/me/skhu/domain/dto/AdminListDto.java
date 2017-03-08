package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Admin;

@Getter
@Setter
@Builder
public class AdminListDto {
	List<Admin> admin;

	public static AdminListDto of(List<Admin> adminList){
		return AdminListDto.builder()
				.admin(adminList)
				.build();
	}

}
