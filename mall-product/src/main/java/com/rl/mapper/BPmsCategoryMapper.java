package com.rl.mapper;

import com.rl.entity.BPmsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/6 22:15
 */
@Mapper
public interface BPmsCategoryMapper {
    List<BPmsCategory> getBPmsCategory();
    List<BPmsCategory> getByBParentCid(@Param("parentCid") Integer parentCid);
    Integer getByName(String name);//根据name获取id
}
