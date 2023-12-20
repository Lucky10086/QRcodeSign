package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_teacher")
public class Teacher {
    private String account;
    private String password;

    public Teacher(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Teacher() {
    }
}
