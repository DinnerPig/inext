/*
* 文 件 名:  FileController
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-08
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * FileController
 *
 * @author zhiliao
 * @since 2017-04-08
 */
@Controller
@RequestMapping("file/")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    //文件上传相关代码

    //文件上传相关代码
    @RequestMapping(value = "/upload")
    //@ResponseBody
    public String upload(HttpServletRequest request, @RequestParam("test") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        //String filePath = request.getServletContext().getRealPath("//WEB-INF//");
        String filePath = "D://test//";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            //return "上传成功";
            return "pc/product";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    //文件下载相关代码
    @RequestMapping("/download")
    public String downloadFile(org.apache.catalina.servlet4preview.http.HttpServletRequest request, HttpServletResponse response){
        //String fileName = "FileUploadTests.java";
        String fileName = "host.txt";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            //String realPath = request.getServletContext().getRealPath("//WEB-INF//");
            String realPath = "D://test//";
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload2(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }




    @RequestMapping(value = "/testUploadFile", method = RequestMethod.POST)
    public void testUploadFile(HttpServletRequest req,
                               MultipartHttpServletRequest multiReq) {
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
        System.out.println("uploadFlePath:" + uploadFilePath);
        // 截取上传文件的文件名
        String uploadFileName = uploadFilePath.substring(
                uploadFilePath.lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));
        System.out.println("multiReq.getFile()" + uploadFileName);
        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(
                uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
        System.out.println("uploadFileSuffix:" + uploadFileSuffix);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = (FileInputStream) multiReq.getFile("file1").getInputStream();

            // 解决中文问题，liunx下中文路径，图片显示问题
            // fileName = UUID.randomUUID() + suffixName;
            // 文件上传后的路径
            //String filePath = ".//uploadFiles//";
            // 文件上传后的路径
            String filePath = "D://test//";
            fos = new FileOutputStream(new File(filePath + uploadFileName
                    + ".")
                    + uploadFileSuffix);
            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1){
                fos.write(temp,0,temp.length);
                fos.flush();
                i = fis.read(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping(value = "testUploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public void handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    String uploadFilePath = file.getOriginalFilename();
                    System.out.println("uploadFlePath:" + uploadFilePath);
                    // 截取上传文件的文件名
                    String uploadFileName = uploadFilePath
                            .substring(uploadFilePath.lastIndexOf('\\') + 1,
                                    uploadFilePath.indexOf('.'));
                    System.out.println("multiReq.getFile()" + uploadFileName);
                    // 截取上传文件的后缀
                    String uploadFileSuffix = uploadFilePath.substring(
                            uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
                    System.out.println("uploadFileSuffix:" + uploadFileSuffix);
                    stream = new BufferedOutputStream(new FileOutputStream(new File(
                            ".//uploadFiles//" + uploadFileName + "." + uploadFileSuffix)));
                    byte[] bytes = file.getBytes();
                    stream.write(bytes,0,bytes.length);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("上传文件为空");
            }
        }
        System.out.println("文件接受成功了");
    }

    @RequestMapping(value = "/testDownload", method = RequestMethod.GET)
    public void testDownload(HttpServletResponse res) {
        String fileName = "upload.jpg";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("d://"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
}