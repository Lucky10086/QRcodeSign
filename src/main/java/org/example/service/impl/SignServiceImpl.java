package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.SignDAO;
import org.example.dao.StuClassDAO;
import org.example.domain.Sign;
import org.example.domain.StuClass;
import org.example.service.SignService;
import org.example.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl extends ServiceImpl<SignDAO, Sign> implements SignService {
    @Autowired
    private SignDAO dao;


    @Override
    public void deleteByclassName(List<String> className) {
        dao.deleteByclassName(className);
    }

    @Override
    public void insertSign(List<String> className) {
        dao.insertSign(className);
    }

    @Override
    public Boolean updateSigned(String sno) {
        return dao.updateSigned(sno);
    }
}
