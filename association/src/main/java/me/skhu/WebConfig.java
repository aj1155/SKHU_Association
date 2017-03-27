package me.skhu;


import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import me.skhu.controller.filter.CORSFilter;
import me.skhu.controller.interceptor.JwtInterceptor;

/**
 * Created by Manki Kim on 2016. 12. 30..
 */
@SpringBootApplication
@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private JwtInterceptor jwtInterceptor;


    @Bean
    public CORSFilter corsFilter(@Value("${dashboard.url}") String dashboardUrl) {
        return new CORSFilter(dashboardUrl);
    }
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/auth/**");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver viewResolver(){
    	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
    	viewResolver.setViewClass(TilesView.class);
    	return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
    	tilesConfigurer.setDefinitionsFactoryClass(TilesDefinitionsConfig.class);
    	tilesConfigurer.setCheckRefresh(true);
    	TilesDefinitionsConfig.addDefinitions();
    	return tilesConfigurer;
    }

    @Bean
    public JavaMailSender mailSender(){
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	//보안 수준이 낮은 앱 허용: 사용
    	//www.google.com/settings/security/lesssecureapps
    	//계정 설정 변경
    	mailSender.setHost("smtp.gmail.com");
    	mailSender.setUsername("sumusb34@gmail.com");
    	mailSender.setPassword("sc5203nv#$");

    	Properties javaMailProperties = new Properties();
    	javaMailProperties.setProperty("mail.smtp.starttls.enable","true");
    	javaMailProperties.setProperty("mail.smtp.auth", "true");
    	mailSender.setJavaMailProperties(javaMailProperties);

    	return mailSender;
    }


}
