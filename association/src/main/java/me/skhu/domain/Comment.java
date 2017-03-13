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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	@Column(name = "board_post_id")
	@NotNull
	private int boardId;

	@Column(name = "content")
	@NotNull
	private String content;

	@NotNull
	@Column(name = "writer_id")
	private int writer_id;

	@NotNull
	@Column(name = "writer_name")
	private String writer_name;

	public static Comment of(String content, Admin admin, int boardId){
		return Comment.builder()
				.boardId(boardId)
				.content(content)
				.writer_id(admin.getId())
				.writer_name(admin.getName())
				.build();
	}

	public static Comment ofEmpty(){
		return Comment.builder()
				.boardId(0)
				.content(null)
				.writer_id(0)
				.writer_name(null)
				.build();
	}
}
