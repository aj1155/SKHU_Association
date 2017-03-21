package me.skhu.service;

import java.util.List;

import me.skhu.domain.Board;
import me.skhu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.dto.BoardDto;
import me.skhu.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public List<BoardDto> findByCategoryId(int categoryId){
		return boardRepository.findByCategoryId(categoryId);
    }

    public Board find(int boardId){
		return boardRepository.findOne(boardId);
	}

	public void saveBoard(User user){
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append(user.getGrade());
    	stringBuilder.append("기자유게시판");
    	if(boardRepository.findByCategoryIdAndBoardType(user.getCategory().getId(),stringBuilder.toString())==null){
    		boardRepository.save(Board.ofCreate(stringBuilder.toString(),user.getCategory().getId()));
		}
	}

}
