package me.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdminDto {

	private String loginId;
	private int categoryId;
	private String categoryName;
	private String email;
	private String birth;
	private String phoneNumber;
	private String name;

	public static AdminDto of(Admin admin){
		return AdminDto.builder()
				.loginId(admin.getLoginId())
				.categoryId(admin.getCategory().getId())
				.categoryName(admin.getCategory().getName())
				.email(admin.getEmail())
				.birth(admin.getBirth())
				.phoneNumber(admin.getPhoneNumber())
				.name(admin.getName()).build();
	}
}
