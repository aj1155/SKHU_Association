package me.skhu.service;

import java.util.List;

import me.skhu.domain.Admin;
import me.skhu.domain.OriginUser;
import me.skhu.repository.OriginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.Position;
import me.skhu.domain.User;
import me.skhu.domain.dto.UserDto;
import me.skhu.domain.dto.UserListDto;
import me.skhu.repository.PositionRepository;
import me.skhu.repository.UserRepository;
import me.skhu.util.Pagination;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private OriginUserRepository originUserRepository;

    public List<User> findByName(String name){
    	return userRepository.findByName(name);
    }

  //관리자 웹페이지
    public UserListDto list(Pagination pagination,int categoryId){
    	return UserListDto.of(userRepository.findAll(pagination));
    }

    public void create(UserDto userDto){
    	User user =User.ofCreate2(userDto,positionRepository.findOne(userDto.getUser_type()));
    	userRepository.save(user);
    }

    public UserDto newUserDto(){
    	UserDto user = UserDto.of(new User());
    	return user;
    }

    public UserDto findById(int id){
    	return UserDto.of(userRepository.findOne(id));
    }

    public User findByUserId(int id){
        return userRepository.findOne(id);
    }
    public void update(UserDto userDto, int id){
    	User user = userRepository.findOne(userDto.getId());
    	user.setName(userDto.getName());
    	user.setCompanyNumber(userDto.getCompanyNumber());
    	user.setPhoneNumber(userDto.getPhoneNumber());
    	user.setStatus(userDto.getStatus());
    	user.setGrade(userDto.getGrade());
    	user.setBirth(userDto.getBirth());
    	user.setEmail(userDto.getEmail());
    	user.setPosition(positionRepository.findOne(userDto.getUser_type()));

    	userRepository.save(user);
    }

    public List<Position> getUserType(){
    	return positionRepository.findAll();
    }

    public List<OriginUser> getEditUser(Pagination pagination){
        return originUserRepository.pagination(pagination,adminService.getCurrentAdmin().getCategory().getId());
    }

    public void save(User user){
        userRepository.save(user);
    }

}
