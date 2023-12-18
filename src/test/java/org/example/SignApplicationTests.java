package org.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.domain.Result;
import org.example.domain.Sign;
import org.example.domain.Student;
import org.example.domain.Teacher;
import org.example.service.QrService;
import org.example.service.SignService;
import org.example.service.StuClassService;
import org.example.service.StudentService;
import org.example.service.impl.TeacherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SignApplicationTests {
    @Autowired
    private SignService signService;


    @Autowired
    private QrService qrService;

    @Autowired
    private TeacherServiceImpl teacher;

    @Autowired
    private StuClassService stuClass;

    @Autowired
    private StudentService student;

    @Test
    void test1(){
        System.out.println(teacher.getTeacher("admin"));
    }

    @Test
    void test2(){
        Boolean admin2 = teacher.saveTeacher(new Teacher("admin2", "123456"));
        System.out.println(admin2);
    }

    @Test
    void test3(){
        List<Student> list = student.list();
        System.out.println(list);
    }

    @Test
    void test4(){
        System.out.println(stuClass.insertClass("class04"));
    }

    @Test
    void test5(){
        Boolean aBoolean = student.deleteStu("0003");
        System.out.println(aBoolean);
    }

    @Test
    void test6(){
        System.out.println(stuClass.list());
    }

    @Test
    void test7(){
        Student student1 = new Student();
        student1.setSclass("class01");
        student1.setSno("0005");
        student1.setSname("dsadsa");
        student1.setSgender("男");
        student.save(student1);
    }

    @Test
    void test8(){
        List<String> list = new ArrayList<String>();
        list.add("class01");
        list.add("class02");
        signService.insertSign(list);
//        signService.deleteByclassName(list);
    }

    @Test
    void test9(){
        System.out.println(signService.updateSigned("0001"));
    }

    @Test
    void test10(){
        String sclass = "class01";
        String condition = "unsigned";
        LambdaQueryWrapper<Sign> lqw = new LambdaQueryWrapper<>();
        lqw.eq(!sclass.isEmpty(),Sign::getSclass,sclass)
                .eq("signed".equals(condition),Sign::getStatus,"已签到")
                .eq("unsigned".equals(condition),Sign::getStatus,"未签到");
//        return new Result(true,signService.list(lqw));
        System.out.println(signService.list(lqw));
    }

}
