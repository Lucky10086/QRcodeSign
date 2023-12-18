package org.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Teacher;

@Mapper
public interface TeacherDAO extends BaseMapper<Teacher> {
    @Select("SELECT * FROM  tb_teacher where account = #{account}")
    Teacher getByAccount(String account);

    @Insert("INSERT INTO tb_teacher VALUES(#{account},#{password})")
    Boolean save(Teacher teacher);
}
