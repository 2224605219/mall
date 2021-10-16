package io.renren.modules.product.feign;

import com.rl.product.entity.PmsAttr;
import com.rl.product.entity.PmsAttrAttrGroupRelation;
import com.rl.product.entity.PmsAttrGroup;
import com.rl.product.entity.PmsCategory;
import io.renren.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**   平台属性---属性分组
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/9 16:16
 */
//@FeignClient("mall-product")
public interface PmsAttrGroupServiceFeign {

    //返回 所有类别 树
    @GetMapping("/attribute/grouping/loadPmsCategoryTree")
    public List<PmsCategory> returnPmsCategory();

    //根据类别id查询组
    @GetMapping("/attribute/PmsAttrGroup/ByCategoryId1")
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId(Integer catelogId);

    //查询所有组
    @GetMapping("/attribute/PmsAttrGroup1")
    public List<PmsAttrGroup> queryPmsAttrGroupsAll( Integer catelogId);

    //根据各个参数查询
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrGroupsByAttr")
    public List<PmsAttrGroup> queryPmsAttrGroupsByAttr(String groupSeachValue);

    //根据组id查询该组下的所有属性
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrByGroupId")
    public List<PmsAttrAttrGroupRelation> queryPmsAttrByGroupId(Integer groupId);

    //根据组id查询该组下没有的所有属性
    @GetMapping("/attribute/PmsAttrGroup/queryPmsAttrByUnGroupId")
    public List<PmsAttr> queryPmsAttrByUnGroupId(@RequestParam("groupId")Integer groupId, @RequestParam("catelogId") Integer catelogId);
    //添加组和属性关联
    @PostMapping("/attribute/PmsAttrGroup/addPmsAttrAttrGroupRelation")
    public R addPmsAttrAttrGroupRelation(@RequestBody com.rl.product.vo.PmsAttrAttrGroupRelation pmsAttrAttrGroupRelation);

    //删除组和属性关联
    @DeleteMapping("/attribute/PmsAttrGroup/deletePmsAttrAttrGroupRelation")
    public R deletePmsAttrAttrGroupRelation(@RequestBody com.rl.product.vo.PmsAttrAttrGroupRelation pmsAttrAttrGroupRelation);


    @PostMapping("/attribute/PmsAttrGroup")
    public R add(@RequestBody PmsAttrGroup pmsAttrGroup);

    @PutMapping("/attribute/PmsAttrGroup")
    public R update(@RequestBody PmsAttrGroup pmsAttrGroup);


    @DeleteMapping("/attribute/PmsAttrGroup")
    public R delete(@RequestBody PmsAttrGroup pmsAttrGroup);

    @DeleteMapping("/attribute/PmsAttrGroup/bachDelete")
    public R bachDelete(@RequestBody com.rl.product.vo.PmsAttrGroup pmsAttrGroup);


}
