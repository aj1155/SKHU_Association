package me.skhu.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.controller.model.request.BoardPostRequest;
import me.skhu.controller.model.response.BoardPostResponse;
import me.skhu.domain.Board;
import me.skhu.domain.BoardPost;
import me.skhu.domain.BoardType;
import me.skhu.domain.dto.BoardPostDto;
import me.skhu.domain.dto.BoardPostListDto;
import me.skhu.repository.BoardPostRepository;
import me.skhu.repository.BoardRepository;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@Service
public class BoardPostService {

    @Autowired
    private BoardPostRepository boardPostRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private BoardRepository boardRepository;

    /***** create *****/

    public BoardPostResponse create(BoardPostRequest boardPostRequest){
        //Todo arguments 줄이기
        BoardPost boardPost = BoardPost.ofCreate(boardPostRequest.getTitle(),boardPostRequest.getContent(),boardPostRequest.getOwnBoardId(),boardPostRequest.getWriter_id(),boardPostRequest.getWriter_name());
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
    public void webDelete(int id){
    	boardPostRepository.delete(id);
    }
    /***** read *****/

    public List<BoardPostResponse> read(int categoryId, BoardType boardType){
        Board board = this.boardRepository.findByCategoryIdAndBoardType(categoryId,boardType);
        List<BoardPost> boardPostList = boardPostRepository.findByOwnBoardId(board.getId());
        return convertBoardPostEntityToResponse(boardPostList);
    }

    /***** update *****/
    //Todo Json Utill 로 return 할 것!
    public Map<String,Object> update(BoardPostRequest boardPostRequest){
        BoardPost boardPost = BoardPost.ofUpdate(boardPostRequest.getId(),boardPostRequest.getTitle(),boardPostRequest.getContent()
                                                    ,boardPostRequest.getOwnBoardId(),boardPostRequest.getWriter_id(),boardPostRequest.getWriter_name());
        this.boardPostRepository.save(boardPost);
        Map<String,Object> resultStatus = new HashMap<String,Object>();
        resultStatus.put("code",200);
        resultStatus.put("msg","정삭적으로 변경했습니다.");

        return resultStatus;
    }
    /***** delete *****/
    //TODO JSON Utill로 return
    public Map<String,Object> delete(int boardPostId){
        this.boardPostRepository.delete(boardPostId);
        Map<String,Object> resultStatus = new HashMap<String,Object>();
        resultStatus.put("code",200);
        resultStatus.put("msg","정상적으로 삭제했습니다");
        return resultStatus;
    }




    private List<BoardPostResponse> convertBoardPostEntityToResponse(List<BoardPost> boardPostList){
        List<BoardPostResponse> boardPostResponses = Optional.ofNullable(boardPostList).orElse(Collections.emptyList()).stream()
                .map(boardPost -> BoardPostResponse.ofBoard(boardPost)).distinct().collect(Collectors.toList());
        return boardPostResponses;
    }
}
