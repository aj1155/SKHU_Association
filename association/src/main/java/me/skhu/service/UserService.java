package me.skhu.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.domain.Position;
import me.skhu.domain.User;
import me.skhu.domain.UserDiscloser;
import me.skhu.domain.dto.UserDto;
import me.skhu.domain.dto.UserListDto;
import me.skhu.repository.CategoryRepository;
import me.skhu.repository.PositionRepository;
import me.skhu.repository.UserDiscloserRepository;
import me.skhu.repository.UserRepository;
import me.skhu.util.PaginationUser;

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
    private CategoryRepository categoryRepository;

    @Autowired
    private UserDiscloserRepository userDiscloserRepository;

    public List<User> findByName(String name){
    	return userRepository.findByName(name);
    }

    //관리자 웹페이지
    public UserListDto list(PaginationUser pagination){
    	if(pagination.getUser_type()==0)
    		return UserListDto.of(userRepository.find(pagination, null));
    	else{
    		Position position = positionRepository.findOne(pagination.getUser_type());
    		return UserListDto.of(userRepository.find(pagination, position));
    	}
    }

    public void delete(String[] del){
    	for(String id : del){
    		this.deleteOne(Integer.parseInt(id));
    	}
    }

    public void deleteOne(int id){
    	userDiscloserRepository.deleteByUserId(id);
    	userRepository.delete(id);
    }

    public void create(UserDto userDto){
    	User user = User.of(userDto, categoryRepository.findOne(1), positionRepository.findOne(userDto.getUser_type()));
    	userRepository.save(user);
    	userDiscloserRepository.save(UserDiscloser.of(user.getId()));
    }

    public UserDto newUserDto(){
    	UserDto user = UserDto.of(new User());
    	return user;
    }

    public UserDto findById(int id){
    	return UserDto.of(userRepository.findOne(id));
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

    public void saveImg(String filePath,int id,MultipartFile uploadFile) throws Exception{
    	uploadFile.transferTo(new File(filePath+"/resources/upload/profileImg/",id+"_img.png"));
    	User user = userRepository.findOne(id);
    	user.setImage("/resources/upload/profileImg/"+id+"_img.png");
    	userRepository.save(user);
    }

    public UserListDto list(){
    	return UserListDto.of(userRepository.findAll());
    }

    public UserListDto getUserMail(String srchType, String srchText){
    	switch(Integer.parseInt(srchType)){
    	case 1 : return UserListDto.of(userRepository.findByGrade(Integer.parseInt(srchText)));
    	case 2 : return UserListDto.of(userRepository.findByName(srchText));
    	default : return UserListDto.of(userRepository.findAll());
    	}
    }


}
