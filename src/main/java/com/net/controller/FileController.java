package com.net.controller;

import com.net.vo.ResponseVO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
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
    @Value("${web.upload.path}")
    private String uploadPath;
    @RequestMapping(value="/uploadfile",method= RequestMethod.POST)
    public ResponseVO upLoadFile(@RequestParam MultipartFile myfiles, HttpServletRequest request) throws IOException {
        String realFileName = "";
        if(myfiles.isEmpty()) {
            return ResponseVO.buildFailure("图片未上传");
        }
        else {
            String realPath = uploadPath;
            realFileName =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"fjj0918"+myfiles.getOriginalFilename();
            String realFileAddress = realPath+realFileName;
            FileUtils.copyInputStreamToFile(myfiles.getInputStream(), new File(realFileAddress));
        }
        return ResponseVO.buildSuccess("/uploads/" + realFileName);
    }

}
