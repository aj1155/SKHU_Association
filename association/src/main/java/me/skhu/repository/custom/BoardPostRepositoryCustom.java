package me.skhu.repository.custom;

import java.util.List;

import me.skhu.domain.BoardPost;
import me.skhu.util.Pagination;

public interface BoardPostRepositoryCustom {

	List<BoardPost> pagination(Pagination pagination,int boardId);

	List<BoardPost> paginationByTitle(Pagination pagination, int boardId);

	List<BoardPost> paginationByUserName(Pagination pagination, int boardId);

	int countByBoardIdAndWriterName(int boardId, String writerName);

	int countByBoardId(int boardId);

	int countByBoardIdAndTitle(int boardId, String title);
}
