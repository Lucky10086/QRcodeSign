package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.TeacherDAO;
import org.example.domain.Teacher;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDAO, Teacher> implements TeacherService {
    @Autowired
    private TeacherDAO dao;

    @Override
    public Teacher getTeacher(String account) {
        return dao.getByAccount(account);
    }

    @Override
    public Boolean saveTeacher(Teacher teacher) {
        Teacher teacher1 = getTeacher(teacher.getAccount());
        if(teacher1 == null) {
            Boolean save = dao.save(teacher);
            return save;
        }
        else{
            return false;
        }
    }
}
