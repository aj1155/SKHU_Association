package me.skhu.repository.Impl;

import java.util.List;

import me.skhu.domain.QBoard;
import me.skhu.domain.QBoardPost;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import me.skhu.domain.BoardPost;
import me.skhu.repository.custom.BoardPostRepositoryCustom;
import me.skhu.util.Pagination;

public class BoardPostRepositoryImpl extends QueryDslRepositorySupport implements BoardPostRepositoryCustom{
	private QBoard qBoard = QBoard.board;
	private QBoardPost qBoardPost = QBoardPost.boardPost;

	public BoardPostRepositoryImpl() {
		super(BoardPost.class);
	}

	@Override
	public List<BoardPost> pagination(Pagination pagination, int boardId){
		return from(qBoardPost)
				.leftJoin(qBoardPost.board, qBoard)
				.where(qBoardPost.board.id.eq(boardId))
				.orderBy(qBoardPost.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public List<BoardPost> paginationByTitle(Pagination pagination, int boardId){
		return from(qBoardPost)
				.leftJoin(qBoardPost.board, qBoard)
				.where(qBoardPost.board.id.eq(boardId),qBoardPost.title.eq(pagination.getSrchText()))
				.orderBy(qBoardPost.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public List<BoardPost> paginationByUserName(Pagination pagination, int boardId){
		return from(qBoardPost)
				.leftJoin(qBoardPost.board, qBoard)
				.where(qBoardPost.board.id.eq(boardId),qBoardPost.writer_name.eq(pagination.getSrchText()))
				.orderBy(qBoardPost.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public int countByBoardIdAndWriterName(int boardId, String writerName){
		return (int) from(qBoardPost)
				.where(qBoardPost.board.id.eq(boardId),qBoardPost.writer_name.eq(writerName))
				.fetchCount();
	}

	@Override
	public int countByBoardId(int boardId){
		return (int) from(qBoardPost)
				.where(qBoardPost.board.id.eq(boardId))
				.fetchCount();
	}

	@Override
	public int countByBoardIdAndTitle(int boardId, String title){
		return (int)from(qBoardPost)
				.where(qBoardPost.board.id.eq(boardId),qBoardPost.title.eq(title))
				.fetchCount();
	}

	@Override
	public int todayBoard(int boardId, DateTime today, DateTime now){
		return (int)from(qBoardPost)
				.where(qBoardPost.board.id.eq(boardId))
				.where(qBoardPost.lastModifiedDate.between(today,now))
				.fetchCount();
	}
}
