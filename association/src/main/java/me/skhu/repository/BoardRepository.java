package me.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Board;
import me.skhu.domain.BoardType;
import me.skhu.domain.dto.BoardDto;

/**
 * Created by Manki Kim on 2017-01-24.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
    Board findByCategoryIdAndBoardType(int categoryId, BoardType boardType);
    List<BoardDto> findByCategoryId(int categoryId);
}
