package com.itheima.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/30 15:53
 * @Version: 1.0
 */

@Component
public class Exp implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv=new ModelAndView();
        if(ex instanceof RuntimeException){
         mv.addObject("expo",ex.getMessage());
         mv.setViewName("error");
        }
        return mv;
    }
}
