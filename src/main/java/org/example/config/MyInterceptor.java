package org.example.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestRemoteAddr = request.getRemoteAddr();
        //System.out.println("HEllo:"+requestRemoteAddr);
        String requestURI = request.getRequestURI();
//        if(requestURI.contains(("/sign"))){
//            System.out.println("sign");
//            response.setContentType("application/json");
//            response.getWriter().write("qiandaojieshu");
//            response.flushBuffer();
//        }
        return true;
    }
}
