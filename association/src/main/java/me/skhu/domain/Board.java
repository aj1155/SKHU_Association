package me.skhu.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@Table(name ="board")
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "board_type")
	@NotNull
	private int boardType;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "category_id")
	@NotNull
	private int categoryId;

	public static Board of(int id, int boardType, String name, int categoryId){
		return Board.builder()
				.id(id)
				.boardType(boardType)
				.name(name)
				.categoryId(categoryId).build();
	}
}
