package com.rl.service;


import com.rl.entity.PmsAttr;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/10 19:49
 */
public interface PmsAttrService {

    /**规格参数*/
    List<PmsAttr> queryPmsAttrsByCategoryId(Integer catelogId);//根据catelogId查询该分类下的所有属性
    List<PmsAttr> queryPmsAttrsAll();
    List<PmsAttr> queryPmsAttrsByValue(String attrSeachValue);//根据不同属性值查询
    /**销售参数*/
    List<PmsAttr> querySalePmsAttrsByCategoryId(Integer catelogId);//根据catelogId查询该分类下的所有属性
    List<PmsAttr> querySalePmsAttrsAll();
    List<PmsAttr> querySalePmsAttrsByValue(String attrSeachValue);//根据不同属性值查询

    void add(PmsAttr pmsAttr);
    void delete(Integer id);
    void bachDel(List<Integer> ids);
    void update(PmsAttr pmsAttr);





}
