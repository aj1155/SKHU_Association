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
@Table(name = "comment")
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	private int id;

	@JoinColumn(name= "board_post_id")
	@NotNull
	@ManyToOne
	private BoardPost boardPost;//TODO

	@Column(name = "content")
	@NotNull
	private String content;

	@NotNull
	@Column(name = "writer_id")
	private int writer_id;

	@NotNull
	@Column(name = "writer_name")
	private String writer_name;

	public static Comment of(int id, BoardPost boardPost, int writer_id,String writer_name, String content){
		return Comment.builder()
				.id(id)
				.boardPost(boardPost)
				.writer_id(writer_id)
				.writer_name(writer_name)
				.content(content).build();
	}
}
