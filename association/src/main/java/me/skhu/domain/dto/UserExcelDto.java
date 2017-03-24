package me.skhu.domain.dto;

import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserExcelDto {
	private int grade;
	private String image;
	private String name;
	private String positionName;
	private String phoneNumber;
	private String companyNumber;
	private String status;
	private String birth;
	private String email;

}
