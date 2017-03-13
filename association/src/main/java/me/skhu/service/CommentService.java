package me.skhu.service;

import me.skhu.domain.Admin;
import me.skhu.domain.Comment;
import me.skhu.domain.User;
import me.skhu.domain.dto.CommentDto;
import me.skhu.repository.CommentRepository;
import me.skhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iljun on 2017-02-24.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AdminService adminService;

    public CommentDto findByBoardId(int boardId){
        return CommentDto.of(commentRepository.findByBoardId(boardId));
    }

    @Transactional(readOnly = false)
    public Comment save(String content, int boardId){
        //TODO web일 경우 ADMIN MOBILE일 경우 user but 댓글은 한번에출력 두개를 어떻게 비교 admin과 user를 어떻게 구분지을것인지
        Admin admin = adminService.getCurrentAdmin();
        Comment comment = Comment.of(content, admin, boardId);
        commentRepository.save(comment);
        return comment;
    }

    @Transactional(readOnly = false)
    public void delete(int id){
       Comment comment = commentRepository.findById(id);
       commentRepository.delete(comment);
    }
}
