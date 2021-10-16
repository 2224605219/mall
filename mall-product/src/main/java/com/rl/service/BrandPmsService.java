package com.rl.service;


import com.rl.entity.BrandPms;

import java.util.List;

/**  品牌关联分类关联表
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/7 20:33
 */
public interface BrandPmsService {
    List<BrandPms> getByBrandId(Integer brandId);
    void add(Integer brandId,Integer pmsId);
    void delete(Integer id);
}
