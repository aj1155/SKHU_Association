package me.skhu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table(name = "boardpost")
@Entity
public class BoardPost {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "title")
	private String title;

	@Lob
	@NotNull
	@Column(name = "content")
	//TODO 조금더 생각해보기
	private String content;

	@NotNull
	@Column(name = "create_time")
	private Date createTime;

	@NotNull
	@Column(name = "modified_time")
	private Date modifiedTime;

	@NotNull
	@JoinColumn(name = "board_id")
	@ManyToOne
	private Board board;

	@NotNull
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	public static BoardPost of(int id, String title, String content, Date createTime, Date modifiedTime, Board board, User user){
		return BoardPost.builder()
				.id(id)
				.title(title)
				.content(content)
				.createTime(createTime)
				.modifiedTime(modifiedTime)
				.board(board)
				.user(user).build();
	}

}
