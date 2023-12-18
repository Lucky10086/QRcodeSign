package org.example.controller;

import org.example.domain.Result;
import org.example.domain.Teacher;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorizations")
public class LoginController {

    @Autowired
    private TeacherService service;

    @GetMapping("/{account}/{password}")
    public Result login(@PathVariable String account,@PathVariable String password){
        Teacher teacher = new Teacher(account,password);
        System.out.println(teacher);
        if(null == service.getTeacher(teacher.getAccount())){
            return new Result(false,null);
        }
        return new Result(true,teacher);
    }

    @PostMapping
    public Result register(@RequestBody Teacher teacher){
        Boolean flag = service.saveTeacher(teacher);
        return new Result(flag,null);
    }
}
