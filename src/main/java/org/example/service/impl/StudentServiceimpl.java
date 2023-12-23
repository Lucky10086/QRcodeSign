package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.StudentDAO;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceimpl extends ServiceImpl<StudentDAO, Student> implements StudentService {


    @Override
    public String insertStudent(String sno, String sname, String sclass) {
        String str = baseMapper.insertStu(sno,sname,"0",sclass);
        return str;
    }

    @Override
    public Boolean deleteStu(String sno) {
        return  baseMapper.deleteBySno(sno);
    }



}
