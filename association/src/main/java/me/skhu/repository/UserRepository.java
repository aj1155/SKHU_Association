package me.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Position;
import me.skhu.domain.User;
import me.skhu.domain.dto.UserDto;
import me.skhu.util.PaginationUser;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<UserDto> findByCategoryId(int categoryId);
    List<UserDto> findByCategoryIdAndGrade(int categoryId, int grade);

    User findByLoginIdAndPassword(String login_id, String password);

    List<User> findByName(String name);
    List<User> findByGrade(int grade);

    Page<User> findByNameContaining(String name, Pageable pageable);
    Page<User> findByGrade(int grade, Pageable pageable);
    Page<User> findByPosition(Position position, Pageable pageable);
    Page<User> findByNameContainingAndPosition(String name, Position position, Pageable pageable);
    Page<User> findByGradeAndPosition(int grade, Position position, Pageable pageable);

    public default List<User> find(PaginationUser pagination,Position position){
    	PageRequest pageRequest = new PageRequest (pagination.getCurrentPage() -1, pagination.getPageSize(), Sort.Direction.DESC, "id");
    	Page<User> page = this.findAll(pageRequest);
    	if(position == null)
    		switch(pagination.getSrchType()){
    		case 1: page=this.findByNameContaining(pagination.getSrchText(), pageRequest); break;
    		case 2: page=this.findByGrade(Integer.parseInt(pagination.getSrchText()), pageRequest); break;
	    	}
    	else{
    		switch(pagination.getSrchType()){
			case 0: page=this.findByPosition(position, pageRequest); break;
			case 1: page=this.findByNameContainingAndPosition(pagination.getSrchText(), position, pageRequest); break;
			case 2: page=this.findByGradeAndPosition(Integer.parseInt(pagination.getSrchText()), position, pageRequest); break;
    		}
    	}
    	pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
    }


}
