package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.SignDAO;
import org.example.domain.Sign;
import org.example.service.SignService;
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

    @Override
    public boolean trySign(String sno, String signedIPAddress) {

        Sign sign = new Sign();
        sign.setStatus("已签到");
        sign.setIp(signedIPAddress);

        return update(sign,new LambdaUpdateWrapper<Sign>().eq(Sign::getSno,sno));
    }
}
