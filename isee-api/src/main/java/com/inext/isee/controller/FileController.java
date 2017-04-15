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

import com.inext.isee.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${downLoad.filePath.video}")
    private String filePath;

    //文件下载相关代码
    @RequestMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileName") String fileName){
        if (fileName != null) {
            FileUtil.downloadFile(request, response, fileName, filePath);
        }
    }
}