package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.domain.Sign;

import java.util.List;

@Mapper
public interface SignDAO extends BaseMapper<Sign> {

//    @Delete("DELETE FROM tb_sign where sno in (SELECT sno FROM tb_student where sclass in #{list})")
    @Delete("<script>"
            + "DELETE  FROM tb_sign "
            + "<where>"
            + "sno in (SELECT sno FROM  tb_student "
            + "<where>"
            + "<if test='list != null'>"
            + "sclass in  "
            + "<foreach item ='i' index = 'index' collection = 'list' open = '(' separator=',' close=')'>"
            + "#{i}"
            + "</foreach>"
            + "</if>"
            + "</where>"
            + ")"
            + "</where>"
            + "</script>")
    void deleteByclassName(@Param("list") List<String> className);

    @Insert("<script>"
            + "INSERT INTO tb_sign(sno,sname,sgender,sclass) SELECT * FROM tb_student "
            + "<where>"
            + "<if test='list != null'>"
            + " sclass in"
            + "<foreach item ='i' index = 'index' collection = 'list' open = '(' separator=',' close=')'>"
            + "#{i}"
            + "</foreach>"
            + "</if>"
            + "</where>"
            + "</script>")
    void insertSign(@Param("list") List<String> className);

    @Update("UPDATE tb_sign SET status = '已签到' where sno = #{sno}")
    Boolean updateSigned(String sno);



}
