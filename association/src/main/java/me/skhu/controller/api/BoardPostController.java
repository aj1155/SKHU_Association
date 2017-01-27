package me.skhu.controller.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.skhu.controller.model.request.BoardPostRequest;
import me.skhu.controller.model.response.AsctApiResponse;
import me.skhu.controller.model.response.BoardPostResponse;
import me.skhu.domain.BoardType;
import me.skhu.service.BoardPostService;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@RestController
@RequestMapping(value = "/api/v1/boardpost")
public class BoardPostController {

    @Autowired
    private BoardPostService boardPostService;


    /***** create *****/
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public AsctApiResponse<BoardPostResponse> create(@Valid @RequestBody BoardPostRequest boardPostRequest){
        BoardPostResponse boardPostResponse = this.boardPostService.create(boardPostRequest);
        return new AsctApiResponse<>(boardPostResponse);
    }

    /***** read *****/
    @RequestMapping(value = "/category/{categoryId}/boardType/{boardType}",method = RequestMethod.GET)
    public AsctApiResponse<List<BoardPostResponse>> read(@PathVariable String categoryId,@PathVariable String boardType){
        List<BoardPostResponse> boardPostResponses = this.boardPostService.read(Integer.parseInt(categoryId), BoardType.valueOf(boardType));
        return new AsctApiResponse<>(boardPostResponses);
    }

    /***** update *****/
    //Todo Json Util만들어서 채워서 보내기
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public AsctApiResponse update(@Valid @RequestBody BoardPostRequest boardPostRequest){
        Map<String,Object> result = this.boardPostService.update(boardPostRequest);
        return new AsctApiResponse<>(result);
    }

    /***** delete *****/
    //Todo JSON Util 만들어서 result 리턴
    @RequestMapping(value = "/{boardPostId}",method = RequestMethod.DELETE)
    public AsctApiResponse delete(@PathVariable String boardPostId){
        Map<String,Object> result = this.boardPostService.delete(Integer.parseInt(boardPostId));
        return new AsctApiResponse<>(result);
    }

}
