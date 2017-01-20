package me.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@JoinColumn(name= "board_id")
	@NotNull
	@ManyToOne
	private BoardPost boardPost;

	@JoinColumn(name="user_id")
	@NotNull
	@OneToOne
	private User user;

	@Column(name = "content")
	@NotNull
	private String content;

	public static Comment of(int id, BoardPost boardPost, User user, String content){
		return Comment.builder()
				.id(id)
				.boardPost(boardPost)
				.user(user)
				.content(content).build();
	}
}
