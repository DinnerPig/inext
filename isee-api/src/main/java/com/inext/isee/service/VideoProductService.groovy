package com.inext.isee.service

import com.inext.isee.dao.IVideoProductDao
import com.inext.isee.entity.product.VideoProduct
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * VideoProductService
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@Service
class VideoProductService {
    @Resource
    IVideoProductDao videoProductDao

    List<VideoProduct> getVideoProductList() {
        videoProductDao.getVideoProductList()
    }

    VideoProduct getVideoProductByNo(String productNo) {
        videoProductDao.getVideoProductByNo(productNo)
    }
}
