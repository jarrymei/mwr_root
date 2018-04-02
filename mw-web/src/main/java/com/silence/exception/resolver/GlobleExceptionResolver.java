package com.silence.exception.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by silence on 2018/4/2.
 */
public class GlobleExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        String xRequestedWith = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(xRequestedWith)) {//判断是否为ajax请求

        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("e", e);
        return mv;
    }
}
