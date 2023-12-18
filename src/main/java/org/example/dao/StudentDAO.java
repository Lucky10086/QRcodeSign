package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.example.domain.Student;

@Mapper
public interface StudentDAO extends BaseMapper<Student> {

    @Delete("DELETE FROM tb_student where sno=#{sno}")
    Boolean deleteBySno(String sno);

}
