package me.skhu;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by iljun on 2017-03-13.
 */
@Configuration
public class ErrorMessageConfig {
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/message/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}