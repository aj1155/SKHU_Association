package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.User;

@Getter
@Setter
@Builder
public class UserListDto {
	List<User> user;

	public static UserListDto of(List<User> userList){
		return UserListDto.builder()
				.user(userList)
				.build();
	}


}
