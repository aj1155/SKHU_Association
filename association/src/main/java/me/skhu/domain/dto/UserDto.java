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

	private int id;
	private String loginId;
	private String name;
	private Integer grade;
	private String birth;
	private String phoneNumber;
	private String email;
	private String status;
	private String companyNumber;
	private Integer user_type;
	private String positionName;
	private String categoryName;

	public static UserDto of(User user){
		return UserDto.builder()
				.loginId(user.getLoginId())
				.name(user.getName())
				.grade(user.getGrade())
				.birth(user.getBirth())
				.phoneNumber(user.getPhoneNumber())
				.email(user.getEmail())
				.status(user.getStatus())
				.companyNumber(user.getCompanyNumber())
				.user_type(user.getPosition()==null ? 0 : user.getPosition().getId())
				.build();
	}

}
