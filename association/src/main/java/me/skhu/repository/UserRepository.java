package me.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.User;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByCategoryId(int categoryId);
    List<User> findByCategoryIdAndGrade(int categoryId, int grade);
}
