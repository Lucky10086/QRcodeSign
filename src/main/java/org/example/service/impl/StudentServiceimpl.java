package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.StudentDAO;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceimpl extends ServiceImpl<StudentDAO, Student> implements StudentService {

    @Autowired
    private StudentDAO dao;
    @Override
    public Boolean deleteStu(String sno) {
        return  dao.deleteBySno(sno);
    }
}
