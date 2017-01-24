package me.skhu.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
	@Enumerated(EnumType.STRING)
	private BoardType boardType;

	@Column(name = "category_id")
	@NotNull
	private int categoryId;

	public Board(int id, BoardType boardTypent,int categoryId){
		this.id = id;
		this.boardType = boardType;
		this.categoryId = categoryId;
	}

}
