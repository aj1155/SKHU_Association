package me.skhu.repository.custom;

import me.skhu.domain.User;

import java.util.List;

/**
 * Created by iljun on 2017-04-19.
 */
public interface UserRepositoryCustom {
    //User findMaxUserNumber(int categoryId);
    List<User> findByCategoryIdAndImage(int categoryId);
}
