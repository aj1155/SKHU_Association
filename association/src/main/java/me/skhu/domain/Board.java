package me.skhu.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="board")
@Entity
public class Board implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "board_type")
	@NotNull
	private String boardType;

	@Column(name = "category_id")
	@NotNull
	private int categoryId;

	public static Board ofCreate(String boardType,int categoryId){
		return Board.builder()
				.boardType(boardType)
				.categoryId(categoryId)
				.build();
	}

}
