package me.skhu.repository;

import me.skhu.domain.BoardImage;
import me.skhu.repository.custom.BoardImageRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by iljun on 2017-03-03.
 */
@Repository
public interface BoardImageRepository extends JpaRepository<BoardImage, Integer>, BoardImageRepositoryCustom{
    BoardImage save(BoardImage boardImage);
    void delete(int boardId);
    //List<BoardImage> findByBoardId(int boardId);
    BoardImage findById(int id);
    BoardImage findByPath(String path);
}
