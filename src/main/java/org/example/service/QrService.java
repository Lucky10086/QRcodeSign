package org.example.service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public interface QrService {


    void generateFile(String content, File file);
    void generateStream(String content, HttpServletResponse response);


}
