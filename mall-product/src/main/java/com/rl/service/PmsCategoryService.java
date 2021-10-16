package com.rl.service;


import com.rl.entity.PmsCategory;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 17:16
 */
public interface PmsCategoryService {

    List<PmsCategory> getPmsCategory();
    void addNode(String name, Integer pId);
    void deleteNode( Integer id);
    void edit(Integer id, String name);
    void batchDel(int[] ids);


}
