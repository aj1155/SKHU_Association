package me.skhu.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

	@JoinColumn(name = "category_id")
	@NotNull
	@ManyToOne
	private Category category;

	public static Board of(int id, int boardType, String name, Category category){
		return Board.builder()
				.id(id)
				.boardType(boardType)
				.name(name)
				.category(category).build();
	}
}
