package org.example.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_sign")
public class Sign {
    private String sno;
    private String sname;
    private String sgender;
    private String sclass;
    private String status;
    private String ip;
}
