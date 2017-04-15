/*
* 文 件 名:  ILevelDao
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-12
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.dao;

import com.inext.isee.entity.product.Level;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ILevelDao
 *
 * @author zhiliao
 * @since 2017-04-12
 */
@Repository
public interface ILevelDao {
    List<Level> getLevelList();

}