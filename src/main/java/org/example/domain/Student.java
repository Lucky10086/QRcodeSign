package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author asd
 */
@Setter
@Getter
@Data
@TableName("tb_student")
public class Student {
    private String sno;
    private String sname;
    private String sgender;
    private String sclass;

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sclass='" + sclass + '\'' +
                '}';
    }
    public  Student(){}


    public Student(String sno, String sname, String sgender, String sclass) {
        this.sno = sno;
        this.sname = sname;
        this.sgender = sgender;
        this.sclass = sclass;
    }

}
