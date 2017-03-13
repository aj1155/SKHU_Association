package me.skhu.config.security;


import lombok.Getter;
import me.skhu.domain.Admin;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by iljun on 2017-02-16.
 */
public class SecurityAdminDetails extends User {

    private static final long serialVersionUID = 1L;

    @Getter
    private String loginId;

    public SecurityAdminDetails(Admin admin){
        super(
                admin.getLoginId(),
                admin.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_ADMIN")
        );
        loginId = admin.getLoginId();
    }
}
