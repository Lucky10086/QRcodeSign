package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.StuClass;

@Mapper
public interface StuClassDAO extends BaseMapper<StuClass> {

    @Insert("INSERT INTO tb_class VALUES (null,#{sclass})")
    Boolean insertClass(String sclass);
}
