package io.renren.modules.product.feign;

import com.rl.product.entity.PmsAttr;
import com.rl.product.entity.PmsAttrGroup;
import io.renren.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/10 20:11
 */
//@FeignClient("mall-product")
public interface PmsAttrServiceFeign {


    /**根据别id查询所有规格参数的属性*/
    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsByCategoryId")
    public List<PmsAttr> queryPmsAttrsByCategoryId(Integer catelogId) ;

    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsAll")
    public List<PmsAttr> queryPmsAttrsAll();

    @GetMapping("/attribute/pmsattrSpecifications/queryPmsAttrsByValue")
    public List<PmsAttr> queryPmsAttrsByValue(String attrSeachValue);

    /**根据别id查询所有销售参数的属性*/
    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsByCategoryId")
    public List<PmsAttr> querySalePmsAttrsByCategoryId(Integer catelogId);

    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsAll")
    public List<PmsAttr> querySalePmsAttrsAll();

    @GetMapping("/attribute/pmsattrSpecifications/querySalePmsAttrsByValue")
    public List<PmsAttr> querySalePmsAttrsByValue(String attrSeachValue) ;



    //根据类别id查询该类别下的组
    //根据类别id查询组
    @GetMapping("/attribute/pmsattrSpecifications/queryGroupBycatelogId")
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId);


    @PostMapping("/attribute/pmsattrSpecifications")
    public R add(@RequestBody com.rl.product.vo.PmsAttr pmsAttr);

    @DeleteMapping("/attribute/pmsattrSpecifications")
    public R delete(Integer attrId) ;

    @DeleteMapping("/attribute/pmsattrSpecifications/bachDel")
    public R bachDel( @RequestBody Integer[] attrIds) ;

    @PutMapping("/attribute/pmsattrSpecifications")
    public R update(PmsAttr pmsAttr);


}
