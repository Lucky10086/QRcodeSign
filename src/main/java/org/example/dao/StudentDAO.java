package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.domain.Student;
import org.example.domain.Teacher;

@Mapper

public interface StudentDAO extends BaseMapper<Student> {

    @Delete("DELETE FROM tb_student where sno=#{sno}")
    Boolean deleteBySno(String sno);
    @Insert("insert into tb_student values(#{sno},#{sname},#{sgender},#{sclass})")
    String insertStu(@Param("sno")String sno,@Param("sname") String sname,@Param("sgender")String sgender,@Param("sclass") String sclass);

}
