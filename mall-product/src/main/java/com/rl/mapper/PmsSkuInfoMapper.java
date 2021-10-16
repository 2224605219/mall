package com.rl.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rl.entity.PmsSkuInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/10/16 15:59
 */
@Mapper
public interface PmsSkuInfoMapper extends BaseMapper<PmsSkuInfo> {
    void insert(PmsSkuInfo pmsSkuInfo);







}
