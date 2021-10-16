package com.rl.service;


import com.rl.entity.Brand;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/3 15:43
 */

public interface BrandService {
    List<Brand> queryAll();
    Brand getById(Integer id);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    void batchDel(int[] ids);
}
