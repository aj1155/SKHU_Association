package me.skhu.config;

import me.skhu.config.security.SecurityAdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
    public void configure(WebSecurity web) throws Exception{
       web
            .ignoring()
            .antMatchers("/resource/**","/");
       //css js파일등 풀어주기
   }

   @Override
    protected void configure(HttpSecurity http) throws Exception{
       http
               .authorizeRequests()
                    .antMatchers("/login")
                    .permitAll()
                    .antMatchers("/**")
                    .authenticated();
       http
               .formLogin()
               .loginProcessingUrl("/login")
               .successForwardUrl("/user/list")
               .failureUrl("/login?error");
       http
               .logout()
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               .logoutSuccessUrl("/login");
       http
               .csrf()
               .disable();
       http
               .headers()
               .frameOptions().sameOrigin()
               .httpStrictTransportSecurity().disable();//security가 iframe을 방어하는걸 제거
   }

   @Configuration
    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
       @Autowired
       SecurityAdminDetailsService adminDetailsService;

       @Bean
       PasswordEncoder passwordEncoder(){
           return new BCryptPasswordEncoder();
       }

       @Override
       public void init(AuthenticationManagerBuilder auth) throws Exception{
           auth.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder());
       }
   }

   public static class MyPasswordEncoder implements PasswordEncoder{
        @Override
        public String encode(CharSequence rawPassword){
            return "EN-"+rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword){
            return encodedPassword.equals(encode(rawPassword));
        }
    }
}