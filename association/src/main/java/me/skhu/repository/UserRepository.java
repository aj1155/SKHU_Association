package me.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Category;
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
    List<User> findByCategory(Category category);
    List<User> findByNameAndCategory(String name, Category category);
    List<User> findByGradeAndCategory(int grade, Category category);

    Page<User> findByCategory(Category category, Pageable pageable);
    Page<User> findByNameContainingAndCategory(String name, Category category, Pageable pageable);
    Page<User> findByGradeAndCategory(int grade, Category category, Pageable pageable);
    Page<User> findByPositionAndCategory(Position position, Category category, Pageable pageable);
    Page<User> findByNameContainingAndPositionAndCategory(String name, Position position, Category category, Pageable pageable);
    Page<User> findByGradeAndPositionAndCategory(int grade, Position position, Category category, Pageable pageable);

    public default List<User> find(PaginationUser pagination,Position position,Category category){
    	PageRequest pageRequest = new PageRequest (pagination.getCurrentPage() -1, pagination.getPageSize(), Sort.Direction.DESC, "id");
    	Page<User> page = this.findByCategory(category,pageRequest);
    	if(position == null)
    		switch(pagination.getSrchType()){
    		case 1: page=this.findByNameContainingAndCategory(pagination.getSrchText(),category,pageRequest); break;
    		case 2: page=this.findByGradeAndCategory(Integer.parseInt(pagination.getSrchText()),category,pageRequest); break;
	    	}
    	else{
    		switch(pagination.getSrchType()){
			case 0: page=this.findByPositionAndCategory(position,category,pageRequest); break;
			case 1: page=this.findByNameContainingAndPositionAndCategory(pagination.getSrchText(), position, category, pageRequest); break;
			case 2: page=this.findByGradeAndPositionAndCategory(Integer.parseInt(pagination.getSrchText()), position, category, pageRequest); break;
    		}
    	}
    	pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
    }


}
