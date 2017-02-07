package me.skhu.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Advertise;

@Getter
@Setter
@Builder
public class AdvertiseListDto {
	private List<Advertise> advertise;

	public static AdvertiseListDto of(List<Advertise> advertise){
		return AdvertiseListDto.builder()
				.advertise(advertise)
				.build();
	}
}
