package me.skhu.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import me.skhu.domain.Admin;
import me.skhu.domain.dto.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.controller.model.response.BoardPostResponse;
import me.skhu.domain.BoardPost;
import me.skhu.repository.BoardPostRepository;
import me.skhu.repository.BoardRepository;
import me.skhu.util.Pagination;

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
    private BoardService boardService;

    @Autowired
    private BoardImageService boardImageService;

    @Autowired
    private AdminService adminService;

    /***** create *****/
/*
    public BoardPostResponse create(BoardPostRequest boardPostRequest){
        //Todo arguments 줄이기
        BoardPost boardPost = BoardPost.ofCreate(boardPostRequest.getTitle(),boardPostRequest.getContent(),boardPostRequest.getOwnBoardId(),boardPostRequest.getWriter_id(),boardPostRequest.getWriter_name());
        this.boardPostRepository.save(boardPost);
        System.out.println(boardPost.getCreatedDate());
        return BoardPostResponse.ofBoard(boardPost);
    }
*/
    @Transactional(readOnly = false)
    public void create(BoardPostInsertDto boardPostInsertDto, MultipartFile[] files, MultipartHttpServletRequest request, int boardId){
    	BoardPost boardPost = BoardPost.of(boardPostInsertDto,boardService.find(boardId),adminService.getCurrentAdmin());
    	System.out.println("boardPost.getBoard().getId()" + boardPost.getBoard().getId());
    	BoardPost b = boardPostRepository.save(boardPost);
    	if(files!=null)
            fileService.upload(b.getId(),files,request);
    	if(request.getHeader("file-name")!=null)
             boardImageService.update(b,request);
    }

    public BoardPostListDto findAll(Pagination pagination,int boardId){
    	switch(pagination.getSrchType()){
    		case 0 :
    			pagination.setRecordCount(boardPostRepository.countByBoardId(boardId));
    			return BoardPostListDto.of(boardPostRepository.pagination(pagination,boardId));
    		case 1 :
    			pagination.setRecordCount(boardPostRepository.countByBoardIdAndTitle(boardId,pagination.getSrchText()));
    			return BoardPostListDto.of(boardPostRepository.paginationByTitle(pagination,boardId));
    		default :
    			pagination.setRecordCount(boardPostRepository.countByBoardIdAndWriterName(boardId,pagination.getSrchText()));
    			return BoardPostListDto.of(boardPostRepository.paginationByUserName(pagination,boardId));
    	}
    }

    public BoardPostEditDto findById(int id){
        return BoardPostEditDto.of(BoardPostDto.of(boardPostRepository.findById(id)),fileService.findByBoardId(id).getFiles());
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
    	fileService.deleteByBoardId(id);
    	boardImageService.delete(id);
    }
    /***** read *****/
/*
    public List<BoardPostResponse> read(int categoryId, BoardType boardType){
        Board board = this.boardRepository.findByCategoryIdAndBoardType(categoryId,boardType);
        List<BoardPost> boardPostList = boardPostRepository.findByOwnBoardId(board.getId());
        return convertBoardPostEntityToResponse(boardPostList);
    }
*/

    /***** update *****/
    //Todo Json Utill 로 return 할 것!
    /*
    public Map<String,Object> update(BoardPostRequest boardPostRequest){
        BoardPost boardPost = BoardPost.ofUpdate(boardPostRequest.getId(),boardPostRequest.getTitle(),boardPostRequest.getContent()
                                                    ,boardPostRequest.getOwnBoardId(),boardPostRequest.getWriter_id(),boardPostRequest.getWriter_name());
        this.boardPostRepository.save(boardPost);
        Map<String,Object> resultStatus = new HashMap<String,Object>();
        resultStatus.put("code",200);
        resultStatus.put("msg","정삭적으로 변경했습니다.");

        return resultStatus;
    }
*/
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

    public BoardPost save(){
        BoardPost boardPost = new BoardPost(null,null);
        return boardPostRepository.save(boardPost);
    }

    public BoardPostInsertDto preInsert(BoardPostInsertDto boardPostInsertDto){
        Admin admin = adminService.getCurrentAdmin();
        boardPostInsertDto.setUesrId(admin.getId());
        boardPostInsertDto.setUserName(admin.getName());
        return boardPostInsertDto;
    }

    @Transactional(readOnly = false)
    public void groupDelete(List<Integer> id){
        for(int i : id) {
            boardPostRepository.delete(i);
        }

    }

    public int[] findByCategoryCount(int categoryId){
        DateTime dateTime = new DateTime();
        DateTime midNight = dateTime.toDateMidnight().toDateTime();
        DateTime now = DateTime.now();
        List<BoardDto> boardList = boardService.findByCategoryId(categoryId);
        int[] list = new int[boardList.size()];
        for(int i=0; i<list.length; i++) {
            list[i]=boardPostRepository.todayBoard(boardList.get(i).getBoardId(), midNight, now);
        }
        return list;
    }
}
