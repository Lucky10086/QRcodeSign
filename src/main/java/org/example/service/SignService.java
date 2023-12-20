package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.Sign;

import java.util.List;

public interface SignService extends IService<Sign> {

    void deleteByclassName(List<String> className);

    void insertSign(List<String> className);

    Boolean updateSigned(String sno);

    boolean trySign(String sno, String signedIPAddress);

}
