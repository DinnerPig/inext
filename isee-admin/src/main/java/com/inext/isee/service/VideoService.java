package com.inext.isee.service;

import com.inext.isee.dao.IVideoProductDao;
import com.inext.isee.entity.product.VideoProduct;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * VideoProductService
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@Service
public class VideoService {
    @Resource
    IVideoProductDao videoProductDao;

    public List<VideoProduct> getVideoProductList() {
        return videoProductDao.getVideoProductList();
    }

    public VideoProduct getVideoProductByNo(String productNo) {
        return videoProductDao.getVideoProductByNo(productNo);
    }

    public int create(VideoProduct video) {
        return videoProductDao.create(video);
    }

    public int updateStatus(VideoProduct video) {
        return videoProductDao.updateStatusByNo(video);
    }
}
