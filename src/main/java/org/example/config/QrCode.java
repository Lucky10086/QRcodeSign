package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.hutool.extra.qrcode.QrConfig;

import java.awt.*;

@Configuration
public class QrCode {
        @Bean
        public QrConfig qrConfig(){
            cn.hutool.extra.qrcode.QrConfig qrConfig = new cn.hutool.extra.qrcode.QrConfig();
            qrConfig.setBackColor(Color.white.getRGB());//设置背景颜色
            qrConfig.setForeColor(Color.black.getRGB());//设置前景色
            return qrConfig;//返回生成的二维码
        }
}
