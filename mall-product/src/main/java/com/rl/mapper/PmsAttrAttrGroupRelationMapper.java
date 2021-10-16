package com.rl.mapper;

import com.rl.entity.PmsAttrAttrGroupRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/12 8:45
 */
@Mapper
public interface PmsAttrAttrGroupRelationMapper {
    List<PmsAttrAttrGroupRelation> queryAll();
    List<PmsAttrAttrGroupRelation> queryByGroupId(Integer groupId);//根据组id查询出所有关联的属性

    void insert(@Param("attrId") Integer attrId, @Param("attrGroupId") Integer attrGroupId);
    void delete(Integer id);
    void bachDel(int[] ids);



}
