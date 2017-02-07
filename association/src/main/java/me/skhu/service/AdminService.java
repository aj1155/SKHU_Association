package me.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.dto.AdminDto;
import me.skhu.domain.dto.UserDto;
import me.skhu.repository.AdminRepository;
import me.skhu.repository.UserRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;

	public AdminDto findByLoginId(String loginId){
		return AdminDto.of(adminRepository.findByLoginId(loginId));
	}

	public List<UserDto> findExcelList(int grade){
		if(grade == 0)
			return userRepository.findByCategoryId(1);
		return userRepository.findByCategoryIdAndGrade(1, grade);
	}
}
