package com.rl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rl.entity.PmsAttr;
import com.rl.mapper.PmsAttrMapper;
import com.rl.service.PmsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/10 19:56
 */
@Service
public class PmsAttrServiceImpl implements PmsAttrService {

    @Autowired
    private PmsAttrMapper pmsAttrMapper;

    /**规格参数*/
    @Override
    public List<PmsAttr> queryPmsAttrsByCategoryId(Integer catelogId) {
        List list = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>().eq("catelog_id", catelogId).eq("attr_type",1).or().eq("attr_type",2));
        return list;
    }

    @Override
    public List<PmsAttr> queryPmsAttrsAll() {
        List list = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>().eq("attr_type",1).or().eq("attr_type",2));
        return list;
    }

    @Override
    public List<PmsAttr> queryPmsAttrsByValue(String attrSeachValue) {
        List<PmsAttr> pmsAttrs = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>()
                .eq("attr_type",1)
                .or().eq("attr_id", attrSeachValue)
                .or().eq("attr_name", attrSeachValue)
                .or().eq("icon", attrSeachValue)
                .or().eq("value_select", attrSeachValue)
                .or().eq("catelog_id", attrSeachValue)
        );
        return pmsAttrs;
    }
    /**销售参数*/
    @Override
    public List<PmsAttr> querySalePmsAttrsByCategoryId(Integer catelogId) {
        List list = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>().eq("catelog_id", catelogId).eq("attr_type",0).or().eq("attr_type",2));
        return list;
    }

    @Override
    public List<PmsAttr> querySalePmsAttrsAll() {
        List list = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>().eq("attr_type",0).or().eq("attr_type",2));
        return list;
    }

    @Override
    public List<PmsAttr> querySalePmsAttrsByValue(String attrSeachValue) {
        List<PmsAttr> pmsAttrs = this.pmsAttrMapper.selectList(new QueryWrapper<PmsAttr>()
                 .eq("attr_type",0)
                .or().eq("attr_id", attrSeachValue)
                .or().eq("attr_name", attrSeachValue)
                .or().eq("icon", attrSeachValue)
                .or().eq("value_select", attrSeachValue)
                .or().eq("catelog_id", attrSeachValue)
        );
        return pmsAttrs;
    }

    /**public*/
    @Override
    public void add(PmsAttr pmsAttr) {
        int insert = this.pmsAttrMapper.insert(pmsAttr);
    }

    @Override
    public void delete(Integer id) {
        int i = this.pmsAttrMapper.deleteById(id);
    }

    @Override
    public void bachDel(List<Integer> ids) {
        int i = this.pmsAttrMapper.deleteBatchIds(ids);
    }

    @Override
    public void update(PmsAttr pmsAttr) {
        int i = this.pmsAttrMapper.updateById(pmsAttr);
    }
}
