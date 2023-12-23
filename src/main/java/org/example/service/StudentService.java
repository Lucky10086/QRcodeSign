package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.Student;

/**
 * @author zjy
 */
public interface StudentService extends IService<Student> {


    String insertStudent(String sno, String sname, String sclass);

    Boolean deleteStu(String sno);

}
