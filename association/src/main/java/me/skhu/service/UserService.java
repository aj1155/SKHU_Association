package me.skhu.service;

import me.skhu.controller.model.request.UserRequest;
import me.skhu.controller.model.response.UserResponse;
import me.skhu.domain.User;
import me.skhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRequest userRequest){

    }

    public List<UserResponse> readUserByCategoryId(int categoryId){
        List<User> list = this.userRepository.findByCategoryId(categoryId);
        return convertUserEntityToResponse(list);
    }

    private List<UserResponse> convertUserEntityToResponse(List<User> userList){
        List<UserResponse> userResponses = Optional.ofNullable(userList).orElse(Collections.emptyList()).stream()
                .map(user -> new UserResponse(user)).distinct().collect(Collectors.toList());

        return userResponses;
    }

}
