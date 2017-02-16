package me.skhu.service;

import java.io.IOException;
import java.util.List;

import me.skhu.domain.Admin;
import me.skhu.domain.Category;
import me.skhu.util.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.User;
import me.skhu.domain.dto.AdminDto;
import me.skhu.domain.dto.UserDto;
import me.skhu.repository.AdminRepository;
import me.skhu.repository.CategoryRepository;
import me.skhu.repository.PositionRepository;
import me.skhu.repository.UserRepository;
import me.skhu.util.Excel;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileService fileService;

	@Autowired
	private Excel excel;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PositionRepository positionRepository;

	public Admin findByLoginId(String loginId){
		return adminRepository.findByLoginId(loginId);
	}

	public List<UserDto> findExcelList(int grade){
		if(grade == 0)
			return userRepository.findByCategoryId(1);
		return userRepository.findByCategoryIdAndGrade(1, grade);
	}

	public List<UserDto> excelRead(MultipartFile file, MultipartHttpServletRequest request) throws IOException {
		String path = fileService.excelUpload(file, request);
		return excel.readExcel(path ,request);
	}

	@Transactional(readOnly = false)
	public void saveuUserList(UserDto userDto){
		//for(int i=0; i<userDto.length; i++)
		System.out.println(categoryRepository.findByName(userDto.getCategoryName()));
		System.out.println(positionRepository.findByName(userDto.getPositionName()));
			userRepository.save(User.of(userDto,categoryRepository.findByName(userDto.getCategoryName()),positionRepository.findByName(userDto.getPositionName())));
	}

	@Transactional(readOnly = false)
	public void saveAdmin(AdminDto adminDto){
		String password = adminDto.getPassword();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		PasswordEncoding passwordEncoding = new PasswordEncoding(passwordEncoder);
		System.out.println(passwordEncoding.encode(password));
		adminDto.setPassword(passwordEncoding.encode(password));

		Category category = categoryRepository.findOne(1);
		adminRepository.save(Admin.of(adminDto,category));
	}

	public Admin getCurrentAdmin(){
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return adminRepository.findByLoginId(authentication.getName());
	}
}
