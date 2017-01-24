package me.skhu.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
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
	private BoardPost boardPost;

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
