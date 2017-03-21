package me.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.skhu.domain.Admin;
import me.skhu.domain.dto.AdminDto;
import me.skhu.domain.dto.AdminListDto;
import me.skhu.repository.AdminRepository;
import me.skhu.repository.CategoryRepository;

@Service
public class AdminUserService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public AdminListDto list(){
		return AdminListDto.of(adminRepository.findAll());
	}

	public AdminDto newAdminDto(){
    	AdminDto admin = AdminDto.of(new Admin());
    	return admin;
    }

	public void create(AdminDto adminDto){
		Admin admin = Admin.create(adminDto,categoryRepository.findOne(adminDto.getCategoryId()),passwordEncoder.encode(adminDto.getBirth()));
		adminRepository.save(admin);
	}

	public AdminDto findById(int id){
		return AdminDto.of(adminRepository.findOne(id));
	}

	public void update(AdminDto adminDto, int id){
		Admin admin = adminRepository.findOne(id);
		admin.setLoginId(adminDto.getLoginId());
		admin.setName(adminDto.getName());
		admin.setEmail(adminDto.getEmail());
		admin.setPhoneNumber(adminDto.getPhoneNumber());
		admin.setBirth(adminDto.getBirth());
		admin.setCategory(categoryRepository.findOne(adminDto.getCategoryId()));

		adminRepository.save(admin);
	}

	public void delete(int id){
		adminRepository.delete(id);
	}



}
