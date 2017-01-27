package me.skhu.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

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
