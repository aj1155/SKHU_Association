package me.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {

	private int id;
	private String name;

	public static CategoryDto of(Category category){
		return CategoryDto.builder()
				.id(category.getId())
				.name(category.getName()).build();
	}
}
