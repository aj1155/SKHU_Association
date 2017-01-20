package me.skhu.service;

import me.skhu.controller.model.request.UserRequest;
import me.skhu.controller.model.response.AsctApiResponse;
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

    public UserResponse createUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getUser_name());
        user.setLoginId(userRequest.getLogin_id());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);
        return new UserResponse(user);
    }

    public List<UserResponse> readUserByCategoryId(int categoryId){
        List<User> list = this.userRepository.findByCategoryId(categoryId);
        return convertUserEntityToResponse(list);
    }

    public List<UserResponse> readUserByGrade(int categoryId,int grade){
        List<User> list = this.userRepository.findByCategoryIdAndGrade(categoryId,grade);
        return convertUserEntityToResponse(list);
    }

    public List<UserResponse> readManagerByGrade(int categoryId,int grade){
        List<User> list = this.userRepository.findByCategoryIdAndGrade(categoryId,grade);
        List<User> managers = Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
                .filter(user -> user.getPosition().getName().startsWith("기수"))
                .collect(Collectors.toList());
        return convertUserEntityToResponse(managers);
    }
    public List<UserResponse> readSeniorManager(int categoryId,int grade){
        List<User> list = this.userRepository.findByCategoryIdAndGrade(categoryId,grade);
        List<User> managers = Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
                .filter(user -> user.getPosition().getName().startsWith("총동문"))
                .collect(Collectors.toList());
        return convertUserEntityToResponse(managers);
    }

    public AsctApiResponse<UserResponse> update(UserRequest userRequest){
        User user = new User(userRequest);
        String msg = validateBeforeUpdate(user);
        if(msg != null){
            return new AsctApiResponse<>(AsctApiResponse.DUPLICATE_LOGINID);
        }else{
            userRepository.save(user);
            return new AsctApiResponse<>(new UserResponse(user));
        }
    }

    private List<UserResponse> convertUserEntityToResponse(List<User> userList){
        List<UserResponse> userResponses = Optional.ofNullable(userList).orElse(Collections.emptyList()).stream()
                .map(user -> new UserResponse(user)).distinct().collect(Collectors.toList());

        return userResponses;
    }



    /* 유효성 검사 */

    private String validateBeforeUpdate(User user) {
        User oldUser = userRepository.findOne(user.getId());
        if (oldUser != null && user.getLoginId() != oldUser.getLoginId())
            return "기존에 사용 중인 휴대번호 입니다.";

        return null;
    }

}
