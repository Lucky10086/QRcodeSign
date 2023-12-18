package org.example.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.example.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@Service
public class QrServiceImpl implements QrService {

    @Autowired
    QrConfig qrConfig;

    @Override
    public void generateFile(String content, File file) {
        QrCodeUtil.generate(content,qrConfig,file);
    }

    @Override
    public void generateStream(String content, HttpServletResponse response) {
        try {
            QrCodeUtil.generate(content,qrConfig,"png",response.getOutputStream());
        } catch (IOException e) {
            System.out.println("this");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
