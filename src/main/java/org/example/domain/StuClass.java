package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_class")
public class StuClass {
    private String sclass;
    private Integer id;
}
