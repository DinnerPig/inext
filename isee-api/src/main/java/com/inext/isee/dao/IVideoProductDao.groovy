package com.inext.isee.dao

import com.inext.isee.entity.product.VideoProduct
import org.springframework.stereotype.Repository

/**
 * IVideoProductDao
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@Repository
interface IVideoProductDao {
    List<VideoProduct> getVideoProductList()
    VideoProduct getVideoProductByNo(String productNo)
}
