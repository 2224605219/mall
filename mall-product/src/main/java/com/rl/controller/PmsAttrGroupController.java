package com.rl.controller;

import com.rl.entity.PmsAttr;
import com.rl.entity.PmsAttrAttrGroupRelation;
import com.rl.entity.PmsAttrGroup;
import com.rl.entity.PmsCategory;
import com.rl.service.PmsAttrAttrGroupRelationService;
import com.rl.service.PmsAttrGroupService;
import com.rl.service.PmsCategoryService;
import com.rl.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**   平台属性---属性分组
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/9 16:16
 */
@RestController
@Slf4j
public class PmsAttrGroupController {

    @Autowired
    private PmsAttrGroupService pmsAttrGroupService;
    @Autowired
    private PmsAttrAttrGroupRelationService pmsAttrAttrGroupRelationService;
    @Autowired
    private PmsCategoryService pmsCategoryService;
    //返回 所有类别 树
    @GetMapping("/attribute/grouping/loadPmsCategoryTree")
    public List<PmsCategory> returnPmsCategory(){
        log.info("/commodity/pmsCategory======returnPmsCategory==");
        List<PmsCategory> pmsCategorys = this.pmsCategoryService.getPmsCategory();
        return pmsCategorys;
    }

    //根据类别id查询组
    @GetMapping("/attribute/PmsAttrGroup/ByCategoryId1")
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId( Integer catelogId){
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupService.queryPmsAttrGroupsByCategoryId(catelogId);
        return pmsAttrGroups;
    }
    //查询所有组
    @GetMapping("/attribute/PmsAttrGroup1")
    public List<PmsAttrGroup> queryPmsAttrGroupsAll( Integer catelogId){
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupService.queryPmsAttrGroupsAll();
        log.info("--------------------------------->"+pmsAttrGroups);
        return pmsAttrGroups;
    }

    //根据各个参数查询
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrGroupsByAttr")
    public List<PmsAttrGroup> queryPmsAttrGroupsByAttr(String groupSeachValue){
        log.info("--------------------------------------->"+groupSeachValue);
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupService.queryPmsAttrGroupsByAttr(groupSeachValue);
        return pmsAttrGroups;
    }

    //根据组id查询该组下的所有属性
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrByGroupId")
    public List<PmsAttrAttrGroupRelation> queryPmsAttrByGroupId(Integer groupId){
        log.info("--------------------------------------->"+groupId);
        List<PmsAttrAttrGroupRelation> pmsAttrAttrGroupRelations = this.pmsAttrAttrGroupRelationService.queryByGroupId(groupId);
        return pmsAttrAttrGroupRelations;
    }

    //根据组id查询该组下没有的所有属性
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrByUnGroupId")
    public List<PmsAttr> queryPmsAttrByUnGroupId(Integer groupId, Integer catelogId){
        log.info("--------------------------------------->"+groupId);
        List<PmsAttr> pmsAttrs = this.pmsAttrAttrGroupRelationService.unQueryByGroupId(groupId,catelogId);
        return pmsAttrs;
    }
    //添加组和属性关联
    @PostMapping("/attribute/PmsAttrGroup/addPmsAttrAttrGroupRelation")
    public R addPmsAttrAttrGroupRelation(@RequestBody com.rl.vo.PmsAttrAttrGroupRelation pmsAttrAttrGroupRelation){
        log.info("---------------------->"+pmsAttrAttrGroupRelation);

        for (int i=0;i<pmsAttrAttrGroupRelation.getPmsAttrIds().length;i++){
            this.pmsAttrAttrGroupRelationService.add(pmsAttrAttrGroupRelation.pmsAttrIds[i],pmsAttrAttrGroupRelation.getAttrGroupId());
        }
        return R.ok().put("code",200).put("msg","添加成功！");
    }

    //删除组和属性关联
    @DeleteMapping("/attribute/PmsAttrGroup/deletePmsAttrAttrGroupRelation")
    public R deletePmsAttrAttrGroupRelation(@RequestBody com.rl.vo.PmsAttrAttrGroupRelation pmsAttrAttrGroupRelation){
        log.info("---------------------->"+pmsAttrAttrGroupRelation);
        this.pmsAttrAttrGroupRelationService.batchDel(pmsAttrAttrGroupRelation.getIds());
        return R.ok().put("code",200).put("msg","删除成功！");
    }


    @PostMapping("/attribute/PmsAttrGroup")
    public R add(@RequestBody PmsAttrGroup pmsAttrGroup){
        log.info("------------add------------------->"+pmsAttrGroup);
        this.pmsAttrGroupService.add(pmsAttrGroup);
        return R.ok().put("code",200).put("msg","添加成功！");
    }

    @PutMapping("/attribute/PmsAttrGroup")
    public R update(@RequestBody PmsAttrGroup pmsAttrGroup){
        this.pmsAttrGroupService.update(pmsAttrGroup);
        return R.ok().put("code",200).put("msg","修改成功！");
    }


    @DeleteMapping("/attribute/PmsAttrGroup")
    public R delete(@RequestBody PmsAttrGroup pmsAttrGroup){
        this.pmsAttrGroupService.delete(pmsAttrGroup.getAttrGroupId());
        return R.ok().put("code",200).put("msg","修改成功！");
    }

    @DeleteMapping("/attribute/PmsAttrGroup/bachDelete")
    public R bachDelete(@RequestBody com.rl.vo.PmsAttrGroup pmsAttrGroup){
        log.info("-------------------=-=-=-=->"+ Arrays.toString(pmsAttrGroup.getAttrGroupIds()));
        this.pmsAttrGroupService.bachDel(Arrays.asList(pmsAttrGroup.getAttrGroupIds()));
        return R.ok().put("code",200).put("msg","修改成功！");
    }













}
