package me.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.controller.model.request.BoardPostRequest;
import me.skhu.controller.model.response.BoardPostResponse;
import me.skhu.domain.BoardPost;
import me.skhu.domain.dto.BoardPostDto;
import me.skhu.domain.dto.BoardPostListDto;
import me.skhu.repository.BoardPostRepository;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@Service
public class BoardPostService {

    @Autowired
    private BoardPostRepository boardPostRepository;

    @Autowired
    private FileService fileService;

    /***** create *****/

    public BoardPostResponse create(BoardPostRequest boardPostRequest){
        //Todo arguments 줄이기
        BoardPost boardPost = new BoardPost(boardPostRequest.getTitle(),boardPostRequest.getContent(),boardPostRequest.getOwnBoardId(),boardPostRequest.getWriter_id(),boardPostRequest.getWriter_name());
        this.boardPostRepository.save(boardPost);
        System.out.println(boardPost.getCreatedDate());
        return BoardPostResponse.ofBoard(boardPost);
    }

    @Transactional(readOnly = false)
    public void create(BoardPostDto boardPostDto,MultipartFile[] files){
    	BoardPost boardPost = new BoardPost(boardPostDto.getTitle(),boardPostDto.getContent(),1,1,"test");
    	BoardPost b = boardPostRepository.save(boardPost);
    	fileService.upload(b.getId(),files);
    }

    public BoardPostListDto findAll(){
    	return BoardPostListDto.of(boardPostRepository.findAll());
    }

    public BoardPostDto findById(int id){
    	return BoardPostDto.of(boardPostRepository.findById(id));
    }

    @Transactional(readOnly = false)
    public void update(BoardPostDto boardPostDto){
    	BoardPost boardPost = boardPostRepository.findOne(boardPostDto.getId());
    	boardPost.setTitle(boardPostDto.getTitle());
    	boardPost.setContent(boardPostDto.getContent());
    	boardPostRepository.save(boardPost);
    }

    @Transactional(readOnly = false)
    public void delete(int id){
    	boardPostRepository.delete(id);
    }
}
