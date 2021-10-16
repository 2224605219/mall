package com.rl.controller;

import com.rl.entity.PmsAttr;
import com.rl.entity.PmsAttrGroup;
import com.rl.service.PmsAttrAttrGroupRelationService;
import com.rl.service.PmsAttrGroupService;
import com.rl.service.PmsAttrService;
import com.rl.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/10 20:11
 */
@RestController
@Slf4j
public class PmsAttrController {

    @Autowired
    private PmsAttrService pmsAttrService;
    @Autowired
    private PmsAttrGroupService pmsAttrGroupService;
    @Autowired
    private PmsAttrAttrGroupRelationService pmsAttrAttrGroupRelationService;

    /**根据别id查询所有规格参数的属性*/
    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsByCategoryId")
    public List<PmsAttr> queryPmsAttrsByCategoryId(Integer catelogId) {
        List<PmsAttr> pmsAttrs = this.pmsAttrService.queryPmsAttrsByCategoryId(catelogId);
        return pmsAttrs;
    }

    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsAll")
    public List<PmsAttr> queryPmsAttrsAll() {
        List<PmsAttr> pmsAttrs = this.pmsAttrService.queryPmsAttrsAll();
        return pmsAttrs;
    }

    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsByValue")
    public List<PmsAttr> queryPmsAttrsByValue(String attrSeachValue) {
        List<PmsAttr> pmsAttrs = this.pmsAttrService.queryPmsAttrsByValue(attrSeachValue);
        return pmsAttrs;
    }

    /**根据别id查询所有销售参数的属性*/
    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsByCategoryId")
    public List<PmsAttr> querySalePmsAttrsByCategoryId(Integer catelogId) {
        List<PmsAttr> pmsAttrs = this.pmsAttrService.querySalePmsAttrsByCategoryId(catelogId);
        return pmsAttrs;
    }

    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsAll")
    public List<PmsAttr> querySalePmsAttrsAll() {
        List<PmsAttr> pmsAttrs = this.pmsAttrService.querySalePmsAttrsAll();
        return pmsAttrs;
    }

    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsByValue")
    public List<PmsAttr> querySalePmsAttrsByValue(String attrSeachValue) {
        List<PmsAttr> pmsAttrs = this.pmsAttrService.querySalePmsAttrsByValue(attrSeachValue);
        return pmsAttrs;
    }



    //根据类别id查询该类别下的组
    //根据类别id查询组
    @GetMapping("/attribute/pmsattrSpecifications/queryGroupBycatelogId")
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId){
        log.info("-------------------------------->"+catelogId);
        List<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupService.queryPmsAttrGroupsByCategoryId(catelogId);
        log.info("-------------------------------->"+pmsAttrGroups);
        return pmsAttrGroups;
    }


    @PostMapping("/attribute/pmsattrSpecifications")
    public R add(@RequestBody com.rl.vo.PmsAttr pmsAttr) {
            log.info("---------------->{}",pmsAttr);

        /**添加属性*/
        this.pmsAttrService.add(new PmsAttr(pmsAttr.getAttrId(),pmsAttr.getAttrName(),pmsAttr.isSearchType()==true? 1:0,pmsAttr.getIcon(),pmsAttr.getValueSelect(),pmsAttr.getAttrType(),pmsAttr.isEnable()==true?1:0,pmsAttr.getCatelogId(), pmsAttr.isShowDesc()==true?1:0,pmsAttr.isValueType()==true?1:0
        ));
        /**关联属性和分组*/
        this.pmsAttrAttrGroupRelationService.add(pmsAttr.getAttrId(),pmsAttr.getGroupId());

        return R.ok().put("code",200).put("msg","添加成功！");
    }

    @DeleteMapping("/attribute/pmsattrSpecifications")
    public R delete(Integer attrId) {
        this.pmsAttrService.delete(attrId);
        return R.ok().put("code",200).put("msg","删除成功！");
    }

    @DeleteMapping("/attribute/pmsattrSpecifications/bachDel")
    public R bachDel( @RequestBody Integer[] attrIds) {
        this.pmsAttrService.bachDel(Arrays.asList(attrIds));
        return R.ok().put("code",200).put("msg","删除成功！");
    }

    @PutMapping("/attribute/pmsattrSpecifications")
    public R update(PmsAttr pmsAttr) {
        this.pmsAttrService.update(pmsAttr);
        return R.ok().put("code",200).put("msg","修改成功！");
    }


}
