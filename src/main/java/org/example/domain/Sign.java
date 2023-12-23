package org.example.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_sign")
public class Sign {
    @TableId(type = IdType.AUTO)
    private int id;
    private String sno;
    private String sname;
    private String sgender;
    private String sclass;
    private String status;
    private String ip;
}
