package me.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OriginUserDto {

	private String loginId;
	private String name;
	private String birth;
	private String phoneNumber;
	private String companyNumber;
	private int grade;
	private String status;
	private String categoryName;

	public static OriginUserDto of(OriginUser originUser){
		return OriginUserDto.builder()
				.loginId(originUser.getLoginId())
				.name(originUser.getName())
				.birth(originUser.getBirth())
				.phoneNumber(originUser.getPhoneNumber())
				.companyNumber(originUser.getCompanyNumber())
				.grade(originUser.getGrade())
				.status(originUser.getStatus())
				.categoryName(originUser.getCategory().getName()).build();
	}
}
