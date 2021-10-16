package com.rl.mapper;


import com.rl.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**  品牌
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/3 15:42
 */
@Mapper
public interface BrandMapper {

    List<Brand> queryAll();
    Brand getById(Integer id);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    void batchDel(int[] ids);


}
