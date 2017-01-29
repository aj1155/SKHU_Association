package me.skhu.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import me.skhu.domain.dto.AdminDto;
import me.skhu.repository.AdminRepository;
import me.skhu.service.AdminService;

@Component
public class SecurityUserDetailsServiceCustom implements UserDetailsService{
	private final AdminRepository adminRepository;
	private final AdminService adminService;

	@Autowired
	public SecurityUserDetailsServiceCustom(AdminRepository adminRepository,AdminService adminService){
		this.adminRepository = adminRepository;
		this.adminService = adminService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminDto adminDto=null;
		try{
			adminDto = adminService.findByLoginId(username);
		}catch(Exception e){
			throw new UsernameNotFoundException("id nowFound");
		}
		SecurityUserDetailsCustom user = new SecurityUserDetailsCustom(adminDto);

		return user;
	}

	public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException{
		AdminDto adminDto=null;
		System.out.println("my");
		System.out.println(username);
		System.out.println(password);
		try{
			adminDto=adminService.findByLoginId(username);
			System.out.println("username: "+username);
		}catch(Exception e){
			throw new UsernameNotFoundException("id notFound");
		}
		SecurityUserDetailsCustom user=null;
		if(adminDto.getPassword().equals(password)==true){
			user = new SecurityUserDetailsCustom(adminDto);
		}
		return user;
	}
}
