package io.renren.modules.product.controller;

import com.rl.product.entity.PmsAttr;
import com.rl.product.entity.PmsAttrGroup;
import io.renren.common.utils.R;
import io.renren.modules.product.feign.PmsAttrServiceFeign;
import io.renren.modules.product.feign.ProductServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/10 20:11
 */
@RestController
@Slf4j
public class PmsAttrController {

//    @Autowired
//    private PmsAttrServiceFeign pmsAttrServiceFeign;

    @Autowired
    private ProductServiceFeign productServiceFeign;

    /**根据别id查询所有规格参数的属性*/
    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsByCategoryId")
    public List<PmsAttr> queryPmsAttrsByCategoryId(Integer catelogId) {
        return this.productServiceFeign.queryPmsAttrsByCategoryId(catelogId);
    }

    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsAll")
    public List<PmsAttr> queryPmsAttrsAll() {
        return this.productServiceFeign.queryPmsAttrsAll();
    }

    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsByValue")
    public List<PmsAttr> queryPmsAttrsByValue(String attrSeachValue) {
        return this.productServiceFeign.queryPmsAttrsByValue(attrSeachValue);
    }

    /**根据别id查询所有销售参数的属性*/
    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsByCategoryId")
    public List<PmsAttr> querySalePmsAttrsByCategoryId(Integer catelogId) {
        return this.productServiceFeign.querySalePmsAttrsByCategoryId(catelogId);
    }

    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsAll")
    public List<PmsAttr> querySalePmsAttrsAll() {
        return this.productServiceFeign.querySalePmsAttrsAll();
    }

    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsByValue")
    public List<PmsAttr> querySalePmsAttrsByValue(String attrSeachValue) {
        return this.productServiceFeign.querySalePmsAttrsByValue(attrSeachValue);
    }



    //根据类别id查询该类别下的组
    //根据类别id查询组
    @GetMapping("/attribute/pmsattrSpecifications/queryGroupBycatelogId")
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId){
        return this.productServiceFeign.queryPmsAttrGroupsByCategoryId(catelogId);
    }


    @PostMapping("/attribute/pmsattrSpecifications")
    public R add(@RequestBody com.rl.product.vo.PmsAttr pmsAttr) {
        return this.productServiceFeign.add(pmsAttr);
    }

    @DeleteMapping("/attribute/pmsattrSpecifications")
    public R delete(Integer attrId) {
        return this.productServiceFeign.delete(attrId);
    }

    @DeleteMapping("/attribute/pmsattrSpecifications/bachDel")
    public R bachDel( @RequestBody Integer[] attrIds) {
        return this.productServiceFeign.bachDel(attrIds);
    }

    @PutMapping("/attribute/pmsattrSpecifications")
    public R update(PmsAttr pmsAttr) {
        return this.productServiceFeign.update(pmsAttr);
    }


}
