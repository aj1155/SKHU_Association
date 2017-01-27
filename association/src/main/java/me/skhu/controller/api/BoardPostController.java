package me.skhu.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.skhu.controller.model.request.BoardPostRequest;
import me.skhu.controller.model.response.AsctApiResponse;
import me.skhu.controller.model.response.BoardPostResponse;
import me.skhu.service.BoardPostService;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@RestController
@RequestMapping(value = "/api/v1/boardpost")
public class BoardPostController {

    @Autowired
    private BoardPostService boardPostService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public AsctApiResponse<BoardPostResponse> create(@Valid @RequestBody BoardPostRequest boardPostRequest){
        BoardPostResponse boardPostResponse = boardPostService.create(boardPostRequest);
        return new AsctApiResponse<>(boardPostResponse);
    }

}
