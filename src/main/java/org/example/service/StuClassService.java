package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.dao.StuClassDAO;
import org.example.domain.StuClass;
import org.springframework.beans.factory.annotation.Autowired;

public interface StuClassService extends IService<StuClass> {
    Boolean insertClass(String sclass);
}
