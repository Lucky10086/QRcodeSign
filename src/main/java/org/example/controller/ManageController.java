package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.config.ExeclFile;
import org.example.domain.Result;
import org.example.domain.Sign;
import org.example.domain.Student;
import org.example.service.QrService;
import org.example.service.SignService;
import org.example.service.StuClassService;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manages")
public class ManageController {
    @Autowired
    private StudentService service;

    @Autowired
    private SignService signService;

    @Autowired
    private QrService qrService;

    @Autowired
    private StuClassService service2;


    private List<String> className = new ArrayList<String>();
    private List<String> usedClassName = new ArrayList<String>();


    @GetMapping
    public Result getAll() {
        List<Student> list = service.list();

        return new Result(true, list);
    }

    @GetMapping("/select")
    public Result getConditionAll(String sname, String sno, String sgender, String sclass) {
        System.out.println(sname + "\n" + sno + "\n" + sgender + "\n" + sclass);
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<>();
        lqw.like(!sname.isEmpty(), Student::getSname, sname)
                .like(!sno.isEmpty(), Student::getSno, sno)
                .like(!sclass.isEmpty(), Student::getSclass, sclass)
                .eq(!sgender.isEmpty(), Student::getSgender, sgender);
        List<Student> list = service.list(lqw);
        return new Result(list != null ? true : false, list);
    }

    @GetMapping("/create")
    public Result createClass(String createclassname) {
        if (usedClassName.contains(createclassname)) {
            return new Result(false, null);
        }
        Boolean aBoolean = service2.insertClass(createclassname);
        return new Result(aBoolean, null);
    }

    @DeleteMapping("/delete")
    public Result deleteStu(String sno) {
        return new Result(service.deleteStu(sno), null);
    }

    @GetMapping("/class")
    public Result getAllClass() {
        service2.list().forEach((c) -> {
            usedClassName.add(c.getSclass());
        });
        return new Result(true, service2.list());
    }

    @PostMapping("/addStu")
    public Result addStu(@RequestBody Student student) {
        System.out.println(student);
        boolean save = service.save(student);
        return new Result(save, null);
    }


    @GetMapping("/qrcode")
    public void generateV3(String content, String sclass, HttpServletResponse servletResponse) throws IOException {
        className.add(sclass);
        qrService.generateStream(content, servletResponse);
    }

    @GetMapping("/sign")
    public Result sign(String sno, String sclass, HttpServletRequest request) {
        if (className.contains(sclass)) {
            //改sql语句
            String signedIPAddress = request.getRemoteAddr();
//            Boolean aBoolean = signService.updateSigned(sno);
            boolean aBoolean = signService.trySign(sno, signedIPAddress);
            return new Result(aBoolean, aBoolean ? "签到成功！" : "签到失败");
        } else {
            return new Result(false, "学号不存在或所在班级未开启签到！");
        }
    }

    @GetMapping("/getAllsign")
    public Result getAllSign() {
        return new Result(true, signService.list());
    }


    @GetMapping("/getsign")
    public Result getSign() {
        if (className.contains("0000")) {
            signService.deleteByclassName(className);
            signService.insertSign(className);
        } else {
            className.add("0000");
        }
        return new Result(true, signService.list());
    }

    @GetMapping("/abortsign")
    public Result abortSign(String sclass) {
        if (className.contains(sclass)) {
            className.remove(sclass);
            return new Result(true, null);
        } else {
            return new Result(false, null);
        }
    }


    @GetMapping("/signed")
    public Result signed(String condition) {
        LambdaQueryWrapper<Sign> lqw = new LambdaQueryWrapper<>();
        lqw.eq("signed".equals(condition), Sign::getStatus, "已签到");
        lqw.eq("unsigned".equals(condition), Sign::getStatus, "未签到");
        return new Result(true, signService.list(lqw));
    }

    @GetMapping("allsignbynlassname")
    public Result allSignByClassName(String sclass, String condition) {
        LambdaQueryWrapper<Sign> lqw = new LambdaQueryWrapper<>();
        lqw.eq(!sclass.isEmpty(), Sign::getSclass, sclass)
                .eq("signed".equals(condition), Sign::getStatus, "已签到")
                .eq("unsigned".equals(condition), Sign::getStatus, "未签到");
        return new Result(true, signService.list(lqw));
    }
    ExeclFile f;
    @PostMapping("/importExcel")
    public Result importExcel(@RequestParam("file") MultipartFile file) {
        try{
            // 处理导入excel的逻辑，将数据保存到数据库
            f.importData(file);
            return new Result(true, "导入成功");
        }catch (Exception e)
        {
            return new Result(false, "导入失败");
        }
    }


}

