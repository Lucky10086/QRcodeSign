package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.Teacher;


public interface TeacherService extends IService<Teacher>{
     Teacher getTeacher(String account);
     Boolean saveTeacher(Teacher teacher);
}
