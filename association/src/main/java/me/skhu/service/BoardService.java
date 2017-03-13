package me.skhu.service;

import java.util.List;

import me.skhu.domain.Board;
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

    public Board find(int categoryId){
		return boardRepository.findOne(1);
	}

}
