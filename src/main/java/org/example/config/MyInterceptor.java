package org.example.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.domain.Sign;
import org.example.service.SignService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * @author zjy
 */

@Component
public class MyInterceptor implements HandlerInterceptor {
    private final SignService signService;

    public MyInterceptor(SignService signService) {
        this.signService = signService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler)
            throws Exception {
        String requestRemoteAddr = request.getRemoteAddr();
        String url = request.getRequestURI();
        if(url.contains(("/sign"))){
            Sign one = signService.getOne(new LambdaQueryWrapper<Sign>()
                    .eq(Sign::getStatus, "已签到")
                    .eq(Sign::getIp, requestRemoteAddr));
            if(one != null) {
                response.setContentType("application/json");
                response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
                response.getWriter().write("已签到");
                response.flushBuffer();
                return  false;
            }
        }
        return true;
    }
}
