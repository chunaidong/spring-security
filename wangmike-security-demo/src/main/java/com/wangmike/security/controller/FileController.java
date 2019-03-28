package com.wangmike.security.controller;

import cn.hutool.core.io.IoUtil;
import com.wangmike.security.entity.FileInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 14:19
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@RestController
@RequestMapping("/file")
public class FileController {


    public static final String FILE_ADDRESS = "H:\\wang-mike\\spring-security\\wangmike-security-demo\\src\\main\\java\\com\\wangmike\\security\\controller";



    @PostMapping
    @ApiOperation(value = "附件上传")
    public FileInfo uploadFile(MultipartFile file) throws Exception{

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        FileInfo fileInfo = new FileInfo(System.currentTimeMillis()+".txt");

        File insertFile = new File(FILE_ADDRESS,fileInfo.getFilePath());

        file.transferTo(insertFile);

        return fileInfo;


    }

    @GetMapping("/{id}")
    @ApiOperation("附件下载")
    public void downloadFile(@ApiParam("附件名称") @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response)throws Exception{

        InputStream inputStream = null;
        OutputStream outputStream = null;

       try {
           inputStream = new FileInputStream(new File(FILE_ADDRESS, id+".txt"));
           outputStream = response.getOutputStream();
           response.setContentType("application/x-download");
           response.addHeader("Content-Disposition", "attachment;filename=test.txt");
           IoUtil.copy(inputStream, outputStream);
       }finally {
           outputStream.flush();
           inputStream.close();
           outputStream.close();
       }


    }



}
