/*
* 文 件 名:  VideoProduct
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-10
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.controller;

import com.inext.isee.entity.product.VideoProduct;
import com.inext.isee.service.VideoService;
import com.inext.isee.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * VideoProduct
 *
 * @author zhiliao
 * @since 2017-04-10
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    @Resource
    VideoService videoService;

    @Value("${upload.filePath.video}")
    private String videoPath;
    @Value("${upload.filePath.picture}")
    private String picturePath;

    @RequestMapping("/list")
    String productList(Model model){
        List<com.inext.isee.entity.product.VideoProduct> videoProductList = videoService.getVideoProductList();
        model.addAttribute("videoList", videoProductList);
        return "pc/video-list";
    }

    @RequestMapping("/pre-add")
    String preAdd(){
        return "pc/file";
    }

    @RequestMapping("/add")
    String add(HttpServletRequest request, @RequestParam("fileType") String fileType, @RequestParam("videoFile") MultipartFile file){
        // 多文件上传处理
        if ("multiFile".equals(fileType)){
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        }
        if ("singleFile".equals(fileType)) {
            // 单文件上传处理
            String fileNo = FileUtil.upload(request,file,videoPath);
            if (!org.springframework.util.StringUtils.isEmpty(fileNo)) {
                String oriFileName = file.getOriginalFilename();
                String fileName = oriFileName.substring(0, oriFileName.lastIndexOf("."));
                VideoProduct videoProduct = new VideoProduct(fileNo, fileName, videoPath+fileNo, "");
                videoService.create(videoProduct);
            }
        }
        return "pc/file";
    }

    /**
     * 下架
     * @param productNo
     * @return
     */
    @RequestMapping("/offSale")
    @ResponseBody
    boolean offSale(String productNo){
        VideoProduct video = new VideoProduct();
        video.setStatus("0");
        video.setProductNo(productNo);
        videoService.updateStatus(video);
        return true;
    }

    /**
     * 上架
     * @param productNo
     * @return
     */
    @RequestMapping("/onSale")
    @ResponseBody
    boolean onSale(String productNo){
        VideoProduct video = new VideoProduct();
        video.setStatus("1");
        video.setProductNo(productNo);
        videoService.updateStatus(video);
        return true;
    }

}