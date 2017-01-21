package me.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table(name = "category")
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "name")
	@NotNull
	private String name;

	public static Category of(int id, String name){
		return Category.builder()
				.id(id)
				.name(name).build();
	}
}
