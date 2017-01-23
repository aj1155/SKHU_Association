package me.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
	@Column(name = "board_id")
	private int boardId;

	@NotNull
	@Column(name = "writer_id")
	private int writer_id;

	@NotNull
	@Column(name = "writer_name")
	private String writer_name;

	@OneToMany(mappedBy="boardPost")
	@Basic(fetch=FetchType.LAZY)
	private List<Comment> commentList;


	public static BoardPost of(int id, String title, String content, Date createTime, Date modifiedTime, int boardId, int writer_id ,String writer_name){
		return BoardPost.builder()
				.id(id)
				.title(title)
				.content(content)
				.createTime(createTime)
				.modifiedTime(modifiedTime)
				.boardId(boardId)
				.writer_id(writer_id)
				.writer_name(writer_name)
				.build();
	}

}
