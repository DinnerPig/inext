package com.inext.isee.controller

import com.inext.isee.entity.product.VideoProduct
import com.inext.isee.service.VideoProductService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * ProductController
 *
 * @author zhiliao
 * @since 2017-04-05
 */
//@RestController
//@RequestMapping("/product")
class ProductController {
    @Resource
    VideoProductService videoProductService

    @RequestMapping("/video_json")
    List<VideoProduct> productJson(){
        List<VideoProduct> videoProductList = videoProductService.getVideoProductList()
        videoProductList
    }

}
