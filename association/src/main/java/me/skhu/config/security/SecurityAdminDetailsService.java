package me.skhu.config.security;

import me.skhu.domain.Admin;
import me.skhu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by iljun on 2017-02-16.
 */
@Service
public class SecurityAdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException{
        Admin admin = adminService.findByLoginId(loginId);
        if(admin==null)
            throw new UsernameNotFoundException("login fail");
        return new SecurityAdminDetails(admin);
    }
}
