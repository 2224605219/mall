package com.rl.service.impl;

import com.rl.entity.BrandPms;
import com.rl.mapper.BrandPmsMapper;
import com.rl.service.BrandPmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/7 20:34
 */
@Service
public class BrandPmsServiceImpl implements BrandPmsService {

    @Autowired
    private BrandPmsMapper brandPmsMapper;

    @Override
    public List<BrandPms> getByBrandId(Integer brandId) {
        return brandPmsMapper.getByBrandId(brandId);
    }

    @Override
    public void add(Integer brandId, Integer PmsId) {
        this.brandPmsMapper.add(brandId, PmsId);
    }

    @Override
    public void delete(Integer id) {
        this.brandPmsMapper.delete(id);
    }
}
