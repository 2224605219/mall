package io.renren.modules.product.controller;

import com.rl.product.entity.PmsAttr;
import com.rl.product.entity.PmsAttrAttrGroupRelation;
import com.rl.product.entity.PmsAttrGroup;
import com.rl.product.entity.PmsCategory;
import io.renren.common.utils.R;
import io.renren.modules.product.feign.PmsAttrGroupServiceFeign;
import io.renren.modules.product.feign.ProductServiceFeign;
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

//    @Autowired
//    private PmsAttrGroupServiceFeign pmsAttrGroupServiceFeign;

    @Autowired
    private ProductServiceFeign productServiceFeign;


    @GetMapping("/attribute/grouping/loadPmsCategoryTree")
    public List<PmsCategory> returnPmsCategory(){
        return this.productServiceFeign.returnPmsCategory();
    }

    //根据类别id查询组
    @GetMapping("/attribute/PmsAttrGroup/ByCategoryId")
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId){
        log.info("====================----------------->"+catelogId);
        return this.productServiceFeign.queryPmsAttrGroupsByCategoryId1(catelogId);
    }
    //查询所有组
    @GetMapping("/attribute/PmsAttrGroup")
    public List<PmsAttrGroup> queryPmsAttrGroupsAll(Integer catelogId){
        return this.productServiceFeign.queryPmsAttrGroupsAll(catelogId);
    }

    //根据各个参数查询
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrGroupsByAttr")
    public List<PmsAttrGroup> queryPmsAttrGroupsByAttr(String groupSeachValue){
        return this.productServiceFeign.queryPmsAttrGroupsByAttr(groupSeachValue);
    }

    //根据组id查询该组下的所有属性
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrByGroupId")
    public List<PmsAttrAttrGroupRelation> queryPmsAttrByGroupId(Integer groupId){
        return this.productServiceFeign.queryPmsAttrByGroupId(groupId);
    }

    //根据组id查询该组下没有的所有属性
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrByUnGroupId")
    public List<PmsAttr> queryPmsAttrByUnGroupId(Integer groupId, Integer catelogId){
        return this.productServiceFeign.queryPmsAttrByUnGroupId(groupId, catelogId);
    }
    //添加组和属性关联
    @PostMapping("/attribute/PmsAttrGroup/addPmsAttrAttrGroupRelation")
    public R addPmsAttrAttrGroupRelation(@RequestBody com.rl.product.vo.PmsAttrAttrGroupRelation pmsAttrAttrGroupRelation){
        return this.productServiceFeign.addPmsAttrAttrGroupRelation(pmsAttrAttrGroupRelation);
    }

    //删除组和属性关联
    @DeleteMapping("/attribute/PmsAttrGroup/deletePmsAttrAttrGroupRelation")
    public R deletePmsAttrAttrGroupRelation(@RequestBody com.rl.product.vo.PmsAttrAttrGroupRelation pmsAttrAttrGroupRelation){
        return this.productServiceFeign.deletePmsAttrAttrGroupRelation(pmsAttrAttrGroupRelation);
    }


    @PostMapping("/attribute/PmsAttrGroup")
    public R add(@RequestBody PmsAttrGroup pmsAttrGroup){
        return this.productServiceFeign.add(pmsAttrGroup);
    }

    @PutMapping("/attribute/PmsAttrGroup")
    public R update(@RequestBody PmsAttrGroup pmsAttrGroup){
        return this.productServiceFeign.update(pmsAttrGroup);
    }


    @DeleteMapping("/attribute/PmsAttrGroup")
    public R delete(@RequestBody PmsAttrGroup pmsAttrGroup){
        return this.productServiceFeign.delete(pmsAttrGroup);
    }

    @DeleteMapping("/attribute/PmsAttrGroup/bachDelete")
    public R bachDelete(@RequestBody com.rl.product.vo.PmsAttrGroup pmsAttrGroup){
        return this.productServiceFeign.bachDelete(pmsAttrGroup);
    }


}
