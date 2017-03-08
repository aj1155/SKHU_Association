package me.skhu.repository;

import me.skhu.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by iljun on 2017-02-24.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    List<Comment> findByBoardId(int boardId);
    void delete(Comment comment);
    Comment findById(int id);
}
