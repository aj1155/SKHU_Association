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

	@Autowired
	private AdminService adminService;

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

	public void findByGrade(int grade){
		String name = grade+"기자유게시판";
		Board board = boardRepository.findByCategoryIdAndBoardType(adminService.getCurrentAdmin().getCategory().getId(),name);
		if(board==null)
			saveGrade(grade);
	}

	public void saveGrade(int grade){
		String name =grade+"기 자유게시판";
		boardRepository.save(Board.ofCreate(name,adminService.getCurrentAdmin().getCategory().getId()));
	}
}
