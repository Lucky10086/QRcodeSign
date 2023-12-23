package org.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.domain.Sign;
import org.example.service.SignService;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zjy
 */
@SpringBootApplication
public class SignApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SignApplication.class, args);
    }


    //防止程序异常结束后,签到表存在脏数据情况
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SignService bean = applicationContext.getBean(SignService.class);
        if(bean.count() <= 0) {return;}
        Sign clearIpAddress = new Sign();
        clearIpAddress.setIp("");
        clearIpAddress.setStatus("");
        bean.update(clearIpAddress,new UpdateWrapper<Sign>().ne("id","-1"));
    }
}
