package com.inext.isee.dao;

import com.inext.isee.entity.product.VideoProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * IVideoProductDao
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@Repository
public interface IVideoProductDao {
    List<VideoProduct> getVideoProductList();
    VideoProduct getVideoProductByNo(String productNo);
    int create(VideoProduct videoProduct);
    int updateStatusByNo(VideoProduct videoProduct);
}
