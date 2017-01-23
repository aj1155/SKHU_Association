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
@Table(name = "file")
@Entity
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	private int id;

	@JoinColumn(name = "board_id")
	@NotNull
	@ManyToOne
	private BoardPost boardPost;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "size")
	@NotNull
	private String size;

	@Column(name = "path")
	@NotNull
	private String path;

	public static File of(int id, BoardPost boardPost, String name, String size, String path){
		return File.builder()
				.id(id)
				.boardPost(boardPost)
				.name(name)
				.size(size)
				.path(path).build();
	}
}
