package com.rl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rl.entity.PmsAttrGroup;
import com.rl.mapper.PmsAttrGroupMapper;
import com.rl.service.PmsAttrGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/9 18:38
 */
@Service
@Slf4j
public class PmsAttrGroupServiceImpl implements PmsAttrGroupService {

    @Autowired
    private PmsAttrGroupMapper pmsAttrGroupMapper;

    @Override
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId) {
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupMapper.selectList(new QueryWrapper<PmsAttrGroup>().eq("catelog_id",catelogId));
        return pmsAttrGroups;
    }

    @Override
    public List<PmsAttrGroup> queryPmsAttrGroupsAll() {
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupMapper.selectList(new QueryWrapper<>());
        return pmsAttrGroups;
    }

    @Override
    public List<PmsAttrGroup> queryPmsAttrGroupsByAttr(String groupSeachValue) {
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupMapper.selectList(new QueryWrapper<PmsAttrGroup>()
                .or().eq("attr_group_id", groupSeachValue)
                .or().eq("attr_group_name", groupSeachValue)
                .or().eq("sort", groupSeachValue)
                .or().eq("descript", groupSeachValue)
                .or().eq("icon", groupSeachValue)
                .or().eq("catelog_id", groupSeachValue));
        return pmsAttrGroups;
    }

    @Override
    public void add(PmsAttrGroup pmsAttrGroup) {
        log.info("===service--dd===>{}",pmsAttrGroup);
        int insert = this.pmsAttrGroupMapper.insert(pmsAttrGroup);
    }

    @Override
    public void delete(Integer id) {
        this.pmsAttrGroupMapper.deleteById(id);
    }

    @Override
    public void bachDel(List<Integer> ids) {
        this.pmsAttrGroupMapper.deleteBatchIds(ids);
    }

    @Override
    public void update(PmsAttrGroup pmsAttrGroup) {
        this.pmsAttrGroupMapper.updateById(pmsAttrGroup);
    }


}
