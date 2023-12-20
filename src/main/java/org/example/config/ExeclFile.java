package org.example.config;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.IOException;

public class ExeclFile {
    public void importData(MultipartFile file) throws IOException {
        FileInputStream xls = null;
        if (file.isEmpty()) {
            xls = (FileInputStream) file;
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(xls);
            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
            HSSFRow row = sheetAt.getRow(0);
            HSSFCell cell = row.getCell(0);
            String cellValue = cell.getStringCellValue();
            System.out.println("获取到的数据是：" + cellValue);
        }
    }


}
