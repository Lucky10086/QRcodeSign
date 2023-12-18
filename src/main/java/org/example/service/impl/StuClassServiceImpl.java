package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.StuClassDAO;
import org.example.domain.StuClass;
import org.example.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuClassServiceImpl extends ServiceImpl<StuClassDAO, StuClass> implements StuClassService {

    @Autowired
    private StuClassDAO dao;

    @Override
    public Boolean insertClass(String sclass) {
        Boolean aBoolean = dao.insertClass(sclass);
        return aBoolean;
    }
}
