package me.skhu.service;

import java.util.*;

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
		List<BoardDto> list = boardRepository.findByCategoryId(categoryId);
		Collections.sort(list, new Comparator<BoardDto>() {
			@Override
			public int compare(BoardDto o1, BoardDto o2) {
				if(o1.getBoardType().equals("공지사항") || o1.getBoardType().equals("자유게시판") || o2.getBoardType().equals("공지사항") || o2.getBoardType().equals("자유게시판") )
					return 1;
				else{
					if(o1.getBoardType().charAt(0)>o2.getBoardType().charAt(0))
						return 1;
					else
						return -1;
				}
			}
		});
		//TODO lambda식으로 교체
		return list;
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
