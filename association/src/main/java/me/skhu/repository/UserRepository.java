package me.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.User;
import me.skhu.domain.dto.UserDto;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<UserDto> findByCategoryId(int categoryId);
    List<UserDto> findByCategoryIdAndGrade(int categoryId, int grade);

    User findByLoginIdAndPassword(String login_id, String password);

    List<User> findByName(String name);

}
