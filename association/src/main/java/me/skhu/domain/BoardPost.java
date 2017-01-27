package me.skhu.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "board_post")
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

	public BoardPost(String title, String content){
		this.title=title;
		this.content=content;
	}
}
