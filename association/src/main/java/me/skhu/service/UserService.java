package me.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.User;
import me.skhu.repository.UserRepository;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findByName(String name){
    	return userRepository.findByName(name);
    }

}
