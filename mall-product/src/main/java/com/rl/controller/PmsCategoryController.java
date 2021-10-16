package com.rl.controller;

import com.rl.po.Result;
import com.rl.service.PmsCategoryService;
import com.rl.vo.DelPmsCategory;
import com.rl.vo.PmsCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 17:25
 */
@RestController
@Slf4j
public class PmsCategoryController {

    @Autowired
    private PmsCategoryService pmsCategoryService;

    //返回 所有类别 树
    @GetMapping("/commodity/pmsCategory")
    public List<com.rl.entity.PmsCategory> returnPmsCategory(){
        log.info("/commodity/pmsCategory======returnPmsCategory==");
        List<com.rl.entity.PmsCategory> pmsCategorys = this.pmsCategoryService.getPmsCategory();
        return pmsCategorys;
    }

    @PostMapping("/commodity/pmsCategory")
    public Result add(@RequestBody PmsCategory pmsCategory){
        log.info("==========_________=========>"+pmsCategory);
        try {
            this.pmsCategoryService.addNode(pmsCategory.getName(), pmsCategory.getId());
            return new Result(200,"添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"添加失败！");
        }
    }

    @PutMapping("/commodity/pmsCategory")
    public Result edit(@RequestBody PmsCategory pmsCategory){
        log.info("==========================0000000000000>"+pmsCategory);
        try {
            this.pmsCategoryService.edit(pmsCategory.getId(),pmsCategory.getName());
            return new Result(200,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"修改失败！");
        }
    }

    @DeleteMapping("/commodity/pmsCategory")
    public Result delete(@RequestBody PmsCategory pmsCategory){
        log.info("3333333333333333333333333>"+pmsCategory);
        try {
            this.pmsCategoryService.deleteNode(pmsCategory.getId());
            return new Result(200,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(200,"删除失败！");
        }
    }
    /**批量删除*/
    @DeleteMapping("/commodity/pmsCategory/batchdel")
    public Result batchdel(@RequestBody DelPmsCategory delPmsCategory){
        log.info("idsidsidsidsidsidsdisidisidisids>"+delPmsCategory);
        try {
            this.pmsCategoryService.batchDel(delPmsCategory.getCheckdNodes());
            return new Result(200,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(200,"删除失败！");
        }
    }


}
