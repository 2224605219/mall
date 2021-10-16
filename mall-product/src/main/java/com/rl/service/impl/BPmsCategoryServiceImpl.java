package com.rl.service.impl;

import com.rl.entity.BPmsCategory;
import com.rl.mapper.BPmsCategoryMapper;
import com.rl.service.BPmsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/6 22:20
 */
@Service
@Slf4j
public class BPmsCategoryServiceImpl implements BPmsCategoryService {

    @Autowired
    private BPmsCategoryMapper bPmsCategoryMapper;

    @Override
    public List<BPmsCategory> getBPmsCategory() {
        List<BPmsCategory> bPmsCategorys = this.bPmsCategoryMapper.getBPmsCategory();
//        log.info(String.valueOf(bPmsCategorys));
        haha(bPmsCategorys);
        return bPmsCategorys;
    }

    @Override
    public Integer getByName(String name) {
        return  this.bPmsCategoryMapper.getByName(name);
    }

    //去掉空的children
    private void haha(List<BPmsCategory> bPmsCategorys){
        if (bPmsCategorys.size()!=0){
            for (BPmsCategory bPmsCategory:bPmsCategorys){
                if (bPmsCategory.getChildren().size()==0)bPmsCategory.setChildren(null);
                else haha(bPmsCategory.getChildren());
            }
        }

    }

}
