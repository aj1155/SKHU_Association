package me.skhu.repository;

import me.skhu.domain.BoardPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Manki Kim on 2017-01-23.
 */
public interface BoardPostRepository extends JpaRepository<BoardPost,Integer> {
    List<BoardPost> findByOwnBoardId(int ownBoardId);
}
