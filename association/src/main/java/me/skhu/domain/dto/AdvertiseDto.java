package me.skhu.domain.dto;

import java.text.SimpleDateFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skhu.domain.Advertise;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseDto {

	private String slogan;
	private String company;
	private String content;
	private String phoneNumber;
	private String startDate;
	private String endDate;
	private int categoryId;
	private String userName;

	static SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static AdvertiseDto of(Advertise advertise){
		return AdvertiseDto.builder()
				.slogan(advertise.getSlogan())
				.company(advertise.getCompany())
				.content(advertise.getContent())
				.startDate(transFormat.format(advertise.getStartDate()))
				.endDate(transFormat.format(advertise.getEndDate()))
				.categoryId(advertise.getCategory().getId())
				.userName(advertise.getUserName())
				.phoneNumber(advertise.getPhoneNumber())
				.build();
	}

	public String getContent(){
		return this.content;
	}

	public void setContent(String content){
		this.content = content;
	}
}
