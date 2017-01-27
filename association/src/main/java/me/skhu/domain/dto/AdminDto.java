package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Admin;

@Getter
@Setter
@Builder
public class AdminDto {

	private String loginId;
	private String password;
	private int categoryId;
	private String categoryName;
	private String email;
	private String birth;
	private String phoneNumber;
	private String name;

	public static AdminDto of(Admin admin){
		return AdminDto.builder()
				.loginId(admin.getLoginId())
				.password(admin.getPassword())
				.categoryId(admin.getCategory().getId())
				.categoryName(admin.getCategory().getName())
				.email(admin.getEmail())
				.birth(admin.getBirth())
				.phoneNumber(admin.getPhoneNumber())
				.name(admin.getName()).build();
	}
}
