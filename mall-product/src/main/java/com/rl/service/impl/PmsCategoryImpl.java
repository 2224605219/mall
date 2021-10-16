package com.rl.service.impl;

import com.rl.entity.PmsCategory;
import com.rl.mapper.PmsCategoryMapper;
import com.rl.service.PmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 17:17
 */
@Service
public class PmsCategoryImpl implements PmsCategoryService {

    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;

    //获取类别  取出来是树
    @Override
    public List<PmsCategory> getPmsCategory() {

//        List<PmsCategory> goodsTree = pmsCategoryMapper.getPmsCategory();
        List<PmsCategory> pmsCategories = this.pmsCategoryMapper.queryAll();
        List<PmsCategory> goodsTree = goodsNode(pmsCategories, 0);
        return goodsTree;
    }
    public List<PmsCategory> goodsNode(List<PmsCategory> pmsCategories,int id){
        List<PmsCategory> pmsCategories2=new ArrayList<>();
        for (int i = 0; i < pmsCategories.size(); i++) {
            if (id==pmsCategories.get(i).getParentCid()){
                pmsCategories2.add(pmsCategories.get(i));
                pmsCategories.get(i).setChildren(goodsNode(pmsCategories,pmsCategories.get(i).getId()));
            }
        }
        return pmsCategories2;
    }

    @Override
    public void addNode(String name, Integer pId) {
        this.pmsCategoryMapper.addNode(name, pId);
    }

    @Override
    public void deleteNode(Integer id) {
        this.pmsCategoryMapper.deleteNode(id);
    }

    @Override
    public void edit(Integer id, String name ) {
        this.pmsCategoryMapper.updateNode(id, name);
    }

    @Override
    public void batchDel(int[] ids) {
        this.pmsCategoryMapper.batchDel(ids);
    }


}
