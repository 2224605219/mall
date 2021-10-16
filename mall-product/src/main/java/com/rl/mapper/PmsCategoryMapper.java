package com.rl.mapper;

import com.rl.entity.PmsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 16:28
 */
@Mapper
public interface PmsCategoryMapper {
    List<PmsCategory> queryAll();
    List<PmsCategory> getPmsCategory();
    List<PmsCategory> getByParentCid(@Param("parentCid") Integer parentCid);
    void addNode(@Param("name")String name,@Param("pId")Integer pId);
    void deleteNode(@Param("id") Integer id);
    void updateNode(@Param("id") Integer id,@Param("name")String name);
    void batchDel(int[] ids);


}
