package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.StuClass;

public interface StuClassService extends IService<StuClass> {
    Boolean insertClass(String sclass);
}
