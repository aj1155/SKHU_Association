package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.AdvertiseCategory;

@Getter
@Setter
@Builder
public class AdvertiseCategoryDto {
	List<AdvertiseCategory> list;

	public static AdvertiseCategoryDto of(List<AdvertiseCategory> advertiseCategory){
		return AdvertiseCategoryDto.builder()
				.list(advertiseCategory)
				.build();
	}
}
