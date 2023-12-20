package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mysql.cj.util.StringUtils;
import org.example.domain.Result;
import org.example.domain.Teacher;
import org.example.service.TeacherService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjy
 */
@RestController
//表示所有类都会返回JSON格式  spring的一个注解
@RequestMapping("/authorizations")
//请求方法是request,接口路径是/authorizations,其实是IP+端口号+路径
public class LoginController {

    private final TeacherService service;

    public LoginController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/{account}/{password}")
    //get方法请求参数包括账户和密码，/authorizations/{account}/{password}
    public Result login(@PathVariable String account, @PathVariable String password) {
        Teacher teacher = new Teacher(account, password);
        //实现teacher类返回Teacher
        System.out.println(teacher);
        if (service.getTeacher(teacher.getAccount())==null) {
            return new Result(false, "账户名错误");
        }
        return new Result(true, teacher);
    }

    @PostMapping
    public Result register(@RequestBody Teacher teacher) {
        Boolean flag = service.saveTeacher(teacher);
        return new Result(flag, null);
    }

    @PostMapping("/login")
    //get方法请求参数包括账户和密码，/authorizations/{account}/{password}
    public Result login(@RequestBody Teacher teacher) {
        if (teacher != null) {
            Teacher one = service.getOne(new LambdaQueryWrapper<Teacher>()
                    .eq(teacher.getAccount() != null, Teacher::getAccount, teacher.getAccount())
                    .eq(!StringUtils.isNullOrEmpty(teacher.getPassword()), Teacher::getPassword, teacher.getPassword()));
            if (one != null) {
                return new Result(true, "登陆成功！");
            }
        }
        return new Result(false,"账号或密码错误！");

    }
}
