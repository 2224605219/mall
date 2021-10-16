package com.rl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rl.entity.PmsAttr;
import com.rl.entity.PmsAttrAttrGroupRelation;
import com.rl.mapper.PmsAttrAttrGroupRelationMapper;
import com.rl.mapper.PmsAttrMapper;
import com.rl.service.PmsAttrAttrGroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/12 9:23
 */
@Service
public class PmsAttrAttrGroupRelationServiceImpl implements PmsAttrAttrGroupRelationService {

    @Autowired
    private PmsAttrAttrGroupRelationMapper pmsAttrAttrGroupRelationMapper;
    @Autowired
    private PmsAttrMapper pmsAttrMapper;
    @Override
    public List<PmsAttrAttrGroupRelation> queryByGroupId(Integer groupId) {
        return this.pmsAttrAttrGroupRelationMapper.queryByGroupId(groupId);
    }

    //根据组id查询该组下没有的所有属性 并且在同一分类中
    @Override
    public List<PmsAttr> unQueryByGroupId(Integer groupId, Integer catelogId) {
        //查出所有的关联的数据
        List<PmsAttrAttrGroupRelation> pmsAttrAttrGroupRelations = this.pmsAttrAttrGroupRelationMapper.queryAll();
        //查处所有的属性的数据
        List<PmsAttr> pmsAttrs = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>().eq("catelog_id",catelogId));
        //处理数据
        System.out.println(pmsAttrs.size());
        System.out.println(pmsAttrAttrGroupRelations.size());
        for (int i = 0 ;i<pmsAttrAttrGroupRelations.size();i++){
            for (int j = 0 ;j<pmsAttrs.size();j++){
                if (pmsAttrs.get(j).getAttrId()==pmsAttrAttrGroupRelations.get(i).getId()){
                    pmsAttrs.remove(j);
                }
            }
        }
        return pmsAttrs;
    }

    @Override
    public void add(Integer attrId, Integer attrGroupId) {
        this.pmsAttrAttrGroupRelationMapper.insert(attrId, attrGroupId);
    }

    @Override
    public void delete(Integer id) {
        this.pmsAttrAttrGroupRelationMapper.delete(id);
    }

    @Override
    public void batchDel(int[] ids) {
        this.pmsAttrAttrGroupRelationMapper.bachDel(ids);
    }
}
