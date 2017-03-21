package me.skhu.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.domain.Category;
import me.skhu.domain.OriginUser;
import me.skhu.domain.Position;
import me.skhu.domain.User;
import me.skhu.domain.UserDiscloser;
import me.skhu.domain.dto.UserDto;
import me.skhu.domain.dto.UserListDto;
import me.skhu.repository.CategoryRepository;
import me.skhu.repository.OriginUserRepository;
import me.skhu.repository.PositionRepository;
import me.skhu.repository.UserDiscloserRepository;
import me.skhu.repository.UserRepository;
import me.skhu.util.Pagination;
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
    private AdminService adminService;

    @Autowired
    private OriginUserRepository originUserRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserDiscloserRepository userDiscloserRepository;

    @Autowired
    private BoardService boardService;

    public List<User> findByName(String name){
    	return userRepository.findByName(name);
    }

    //관리자 웹페이지
    public UserListDto list(PaginationUser pagination){
    	Category category = adminService.getCurrentAdmin().getCategory();
    	if(pagination.getUser_type()==0)
    		return UserListDto.of(userRepository.find(pagination, null, category));
    	else{
    		Position position = positionRepository.findOne(pagination.getUser_type());
    		return UserListDto.of(userRepository.find(pagination, position, category));
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
    	boardService.saveBoard(user);
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

    public void saveImg(String filePath,int id,MultipartFile uploadFile) throws Exception{
    	uploadFile.transferTo(new File(filePath+"/resources/upload/profileImg/",id+"_img.png"));
    	User user = userRepository.findOne(id);
    	user.setImage("/resources/upload/profileImg/"+id+"_img.png");
    	userRepository.save(user);
    }

    public UserListDto list(){
    	return UserListDto.of(userRepository.findAll());
    }


    public List<OriginUser> getEditUser(Pagination pagination){
        return originUserRepository.pagination(pagination,adminService.getCurrentAdmin().getCategory().getId());
    }

    public void save(User user){
        userRepository.save(user);
    }

    public UserListDto getUserMail(String srchType, String srchText){
    	switch(Integer.parseInt(srchType)){
    	case 1 : return UserListDto.of(userRepository.findByGradeAndCategory(Integer.parseInt(srchText),adminService.getCurrentAdmin().getCategory()));
    	case 2 : return UserListDto.of(userRepository.findByNameAndCategory(srchText,adminService.getCurrentAdmin().getCategory()));
    	default : return UserListDto.of(userRepository.findByCategory(adminService.getCurrentAdmin().getCategory()));
    	}
    }

}
