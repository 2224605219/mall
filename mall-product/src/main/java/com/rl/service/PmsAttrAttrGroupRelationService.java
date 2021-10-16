package com.rl.service;


import com.rl.entity.PmsAttr;
import com.rl.entity.PmsAttrAttrGroupRelation;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/12 9:22
 */
public interface PmsAttrAttrGroupRelationService {
    List<PmsAttrAttrGroupRelation> queryByGroupId(Integer groupId);//根据组id查询出所有关联的属性
    List<PmsAttr> unQueryByGroupId(Integer groupId, Integer catelogId);//根据组id查询出所有没有关联的属性
    void add(Integer attrId, Integer attrGroupId);
    void delete(Integer id);
    void batchDel(int[] ids);
}
