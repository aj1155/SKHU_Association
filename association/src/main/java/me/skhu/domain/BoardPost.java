package me.skhu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Table(name = "board_post")
@Entity
public class BoardPost extends BaseEntity implements Serializable{

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
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
	@Column(name = "own_board_id")
	private int ownBoardId;

	@NotNull
	@Column(name = "writer_id")
	private int writer_id;

	@NotNull
	@Column(name = "writer_name")
	private String writer_name;

	@OneToMany(mappedBy="boardPost")
	@Basic(fetch=FetchType.LAZY)
	private Collection<Comment> commentList;

	public BoardPost(String title, String content, int boardId, int writer_id ,String writer_name){
		this.title = title;
		this.content = content;
		this.ownBoardId = boardId;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
	}
}
