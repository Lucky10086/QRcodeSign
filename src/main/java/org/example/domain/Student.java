package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_student")
public class Student {
    private String sno;
    private String sname;
    private String sgender;
    private String sclass;
}
