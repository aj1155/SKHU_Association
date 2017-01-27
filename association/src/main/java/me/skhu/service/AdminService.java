package me.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.dto.AdminDto;
import me.skhu.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public AdminDto findByLoginId(String loginId){
		return AdminDto.of(adminRepository.findByLoginId(loginId));
	}
}
