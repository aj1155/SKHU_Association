package me.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.skhu.domain.BoardPost;

/**
 * Created by Manki Kim on 2017-01-23.
 */
public interface BoardPostRepository extends JpaRepository<BoardPost,Integer> {
	@Override
	List<BoardPost> findAll();

	BoardPost findById(int id);

	@Override
	BoardPost save(BoardPost boardPost);
}
