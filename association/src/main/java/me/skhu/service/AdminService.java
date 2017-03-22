package me.skhu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.skhu.domain.Admin;
import me.skhu.domain.Category;
import me.skhu.domain.dto.UserExcelDto;
import me.skhu.util.Excel.ExcelReadOption;
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
import me.skhu.util.Excel.ExcelRead;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileService fileService;

	@Autowired
	private ExcelRead excel;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private AdminService adminService;

	public Admin findByLoginId(String loginId){
		return adminRepository.findByLoginId(loginId);
	}

	public List<UserDto> findExcelList(){
		return userRepository.findByCategoryId(adminService.getCurrentAdmin().getCategory().getId());
	}

	public List<UserExcelDto> excelRead(MultipartFile file, MultipartHttpServletRequest request) throws IOException {
		String path = fileService.excelUpload(file, request);
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(path);
		excelReadOption.setColumns("B","C","D","E","F","G","H","I","J","K");
		excelReadOption.setStartRow(2);
		List<Map<String,String>> excelResult = ExcelRead.readExcel(excelReadOption,path);
		List<UserExcelDto> list = new ArrayList<UserExcelDto>();
		for(Map<String,String> content : excelResult){
			UserExcelDto userExcelDto = new UserExcelDto();
			System.out.println(content.get("B"));
			userExcelDto.setCategoryName(content.get("B"));
			userExcelDto.setGrade((int)(Double.parseDouble(content.get("C").substring(0,1))));
			userExcelDto.setImage(content.get("D"));
			userExcelDto.setName(content.get("E"));
			userExcelDto.setPositionName(content.get("F"));
			userExcelDto.setPhoneNumber(content.get("G"));
			userExcelDto.setCompanyNumber(content.get("H"));
			userExcelDto.setStatus(content.get("I"));
			userExcelDto.setBirth(content.get("J"));
			userExcelDto.setEmail(content.get("K"));
			list.add(userExcelDto);
		}
		return list;
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
