package me.skhu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skhu.domain.User;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String name;
	private int grade;
	private String phoneNumber;
	private String companyNumber;
	private String status;
	private String birth;
	private String email;
	private String positionName;
	private String categoryName;

	public static UserDto of(User user){
		return UserDto.builder()
				.name(user.getName())
				.grade(user.getGrade())
				.phoneNumber(user.getPhoneNumber())
				.companyNumber(user.getCompanyNumber())
				.status(user.getStatus())
				.birth(user.getBirth())
				.email(user.getEmail())
				.positionName(user.getPosition().getName())
				.categoryName(user.getCategory().getName())
				.build();
	}
}
