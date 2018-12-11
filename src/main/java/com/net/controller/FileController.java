package com.net.controller;

import com.net.vo.ResponseVO;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author fjj
 * @date 2018/12/11 下午9:11
 */
@RestController
public class FileController {

    @RequestMapping(value="/uploadfile",method= RequestMethod.POST)
    public ResponseVO upLoadFile(@RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException {
        //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
        String realFileAddress = "";
        for(MultipartFile myfile : myfiles) {
            if(myfile.isEmpty()) {
                System.out.println("文件未上传"); continue;
            }
            else {
                //如果用的是Tomcat服务器，则文件会上传到TOMCAT_HOME webapps YourWebProject WEB-INF upload 文件夹中
                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload")+ File.separator;
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
                //文件名，分隔符为fjj0918,开头加上时间用来应对同名文件
                String realFileName =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"fjj0918"+myfile.getOriginalFilename();

                realFileAddress = realPath+realFileName;

                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realFileAddress));
            }
        }
        return ResponseVO.buildSuccess(realFileAddress);
    }

}
