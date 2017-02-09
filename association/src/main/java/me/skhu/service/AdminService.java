package me.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public AdminDto findByLoginId(String loginId){
		return AdminDto.of(adminRepository.findByLoginId(loginId));
	}

	public List<UserDto> findExcelList(int grade){
		if(grade == 0)
			return userRepository.findByCategoryId(1);
		return userRepository.findByCategoryIdAndGrade(1, grade);
	}

	public List<UserDto> excelRead(MultipartFile file, MultipartHttpServletRequest request){
		String path = fileService.excelUpload(file, request);
		return excel.readExcel(path);
	}

	@Transactional(readOnly = false)
	public void saveuUserList(UserDto[] userDto){
		for(int i=0; i<userDto.length; i++)
			userRepository.save(User.of(userDto[i],categoryRepository.findByName(userDto[i].getName()),positionRepository.findByName(userDto[i].getPositionName())));
	}
}
