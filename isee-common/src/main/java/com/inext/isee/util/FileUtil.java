/*
* 文 件 名:  FileUtil
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-10
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.util;

import java.io.*;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

/**
 * FileUtil
 *
 * @author zhiliao
 * @since 2017-04-10
 */
public class FileUtil
{
    
    // 文件上传相关代码
    public static String singleUpload(MultipartFile file, String filePath)
    {
        if (file.isEmpty())
        {
            return null;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        // String filePath =
        // request.getServletContext().getRealPath("//WEB-INF//");
        // 解决中文问题，liunx下中文路径，图片显示问题
        String fileNo = UUID.randomUUID().toString().replace("-", "");
        fileName = fileNo + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists())
        {
            dest.getParentFile().mkdirs();
        }
        try
        {
            file.transferTo(dest);
            return fileNo;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 多文件上传
     * 
     * @param files
     * @return
     */
    public static List<String> multiUpload(List<MultipartFile> files, String filePath)
    {
        List<String> fileNoList = Lists.newArrayList();
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i)
        {
            file = files.get(i);
            String fileNo = singleUpload(file, filePath);
            if (!StringUtils.isEmpty(fileNo))
            {
                fileNoList.add(fileNo);
            }
        }
        if (fileNoList.size() != 2)
        {
            return null;
        }
        else
        {
            return fileNoList;
        }
    }

    public static String downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath){
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            //String realPath = request.getServletContext().getRealPath("//WEB-INF//");
            //String realPath = "D://test//";
            File file = new File(filePath, fileName);
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
                    response.setStatus(404);
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
    
}