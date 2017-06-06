package me.skhu.controller.admin;

import me.skhu.service.LogService;
import me.skhu.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by iljun on 2017-06-06.
 */
@ControllerAdvice
public class MyExceptionHanler {

    @Autowired
    private LogService logService;

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHanler(Exception e, HttpServletRequest request){
        String view = "user/list";
        ModelAndView model = new ModelAndView(view);
        String errorMsg = e.getMessage();
        System.out.println("views : " + view);
        System.out.println("errorMsg : " + errorMsg);
        logService.logError(e);
        return model;
    }
}
