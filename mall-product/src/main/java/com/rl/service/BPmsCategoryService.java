package com.rl.service;


import com.rl.entity.BPmsCategory;

import java.util.List;


/** 商品管理  ——品牌——分类
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/6 22:15
 */
public interface BPmsCategoryService {
    List<BPmsCategory> getBPmsCategory();
    Integer getByName(String name);
}
