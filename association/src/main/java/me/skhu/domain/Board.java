package me.skhu.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Table(name ="board")
@Entity
public class Board implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "board_type")
	@NotNull
	@Enumerated(EnumType.STRING)
	private BoardType boardType;

	@Column(name = "category_id")
	@NotNull
	private int categoryId;

	public static Board of(int id, BoardType boardType, String name, int categoryId){
		return Board.builder()
				.id(id)
				.boardType(boardType)
				.categoryId(categoryId).build();
	}
}
