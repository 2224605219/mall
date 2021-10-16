package io.renren.modules.product.feign;

import com.rl.product.entity.*;
import com.rl.product.po.BrandPmsTabData;
import com.rl.product.po.Result;
import com.rl.product.vo.AddBrand;
import com.rl.product.vo.BrandPms;
import com.rl.product.vo.DelPmsCategory;
import io.renren.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/10/8 17:17
 */
@FeignClient("mall-product")
public interface ProductServiceFeign {

    @PostMapping("/commodity/brand/upload")
    public String upload(@RequestBody MultipartFile picFile);

    //brand品牌查询
    @GetMapping("/commodity/brand")
    public List<Brand> query();

    //brand品牌查询 根据品牌name查询
    @GetMapping("/commodity/brand/getByBrandName")
    public List<Brand> getByBrandName(com.rl.product.vo.Brand brand);


    @GetMapping("/commodity/brand/querybyid")
    public Brand queryById(com.rl.product.vo.Brand brand);

    @PostMapping("/commodity/brand")
    public R add(@RequestBody AddBrand addBrand);

    @PutMapping("/commodity/brand")
    public R edit(@RequestBody com.rl.product.vo.Brand brand);

    @DeleteMapping("/commodity/brand")
    public R delete(@RequestBody Brand brand);


    /**获取所有的分类*/
    @PostMapping("/commodity/brand/getpmsCategorys")
    public List<BPmsCategory> getBPmsCategorys();

    /**添加关联分类*/
    @PostMapping("/commodity/brand/branPms")
    public R add(@RequestBody BrandPms brandPms);

    @GetMapping("/commodity/brand/branPms")
    public List<BrandPmsTabData> queryBrandPms(BrandPms brandPms);

    @DeleteMapping("/commodity/brand/branPms")
    public R deleteBrandPms(@RequestBody BrandPms brandPms);

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
    public List<PmsAttrGroup> queryPmsAttrGroupsByCategoryId1(Integer catelogId);


    @PostMapping("/attribute/pmsattrSpecifications")
    public R add(@RequestBody com.rl.product.vo.PmsAttr pmsAttr);

    @DeleteMapping("/attribute/pmsattrSpecifications")
    public R delete(Integer attrId) ;

    @DeleteMapping("/attribute/pmsattrSpecifications/bachDel")
    public R bachDel( @RequestBody Integer[] attrIds) ;

    @PutMapping("/attribute/pmsattrSpecifications")
    public R update(PmsAttr pmsAttr);

    //返回 所有类别 树
    @GetMapping("/commodity/pmsCategory")
    public List<com.rl.product.entity.PmsCategory> returnPmsCategory1();

    @PostMapping("/commodity/pmsCategory")
    public Result add(@RequestBody com.rl.product.vo.PmsCategory pmsCategory);

    @PutMapping("/commodity/pmsCategory")
    public Result edit(@RequestBody com.rl.product.vo.PmsCategory pmsCategory);

    @DeleteMapping("/commodity/pmsCategory")
    public Result delete(@RequestBody com.rl.product.vo.PmsCategory pmsCategory);
    /**批量删除*/
    @DeleteMapping("/commodity/pmsCategory/batchdel")
    public Result batchdel(@RequestBody DelPmsCategory delPmsCategory);






}
