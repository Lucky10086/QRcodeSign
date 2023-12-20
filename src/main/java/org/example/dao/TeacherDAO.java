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
//查该账户后是否存在
    @Select("SELECT * FROM  tb_teacher where account = #{account} and password = #{password}")
    Boolean result(Teacher teacher);
    @Insert("INSERT INTO tb_teacher VALUES(#{account},#{password})")
    Boolean save(Teacher teacher);
}
