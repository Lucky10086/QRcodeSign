package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.Sign;
import org.example.domain.StuClass;

import java.util.List;

public interface SignService extends IService<Sign> {

    void deleteByclassName(List<String> className);

    void insertSign(List<String> className);

    Boolean updateSigned(String sno);
}
