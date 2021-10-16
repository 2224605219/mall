package com.rl.service;


import com.rl.entity.PmsAttrGroup;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/9 18:38
 */
public interface PmsAttrGroupService {

    List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId);
    List<PmsAttrGroup> queryPmsAttrGroupsAll();
    List<PmsAttrGroup> queryPmsAttrGroupsByAttr(String groupSeachValue);//根据不同属性值查询
    void add(PmsAttrGroup pmsAttrGroup);
    void delete(Integer id);
    void bachDel(List<Integer> ids);
    void update(PmsAttrGroup pmsAttrGroup);



}
