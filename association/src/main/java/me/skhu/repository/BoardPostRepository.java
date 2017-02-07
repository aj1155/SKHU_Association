package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.skhu.domain.BoardPost;
import me.skhu.repository.custom.BoardPostRepositoryCustom;

/**
 * Created by Manki Kim on 2017-01-23.
 */
public interface BoardPostRepository extends JpaRepository<BoardPost,Integer>, BoardPostRepositoryCustom {

	BoardPost findById(int id);

	@Override
	BoardPost save(BoardPost boardPost);

    //List<BoardPost> findByOwnBoardId(int ownBoardId);

}
