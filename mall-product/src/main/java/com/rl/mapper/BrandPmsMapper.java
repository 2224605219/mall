package com.rl.mapper;


import com.rl.entity.BrandPms;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/** 品牌关联分类
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/6 10:11
 */
@Mapper
public interface BrandPmsMapper {
    List<BrandPms> getByBrandId(Integer brandId);
    void add(Integer brandId,Integer pmsId);
    void delete(Integer id);
}
