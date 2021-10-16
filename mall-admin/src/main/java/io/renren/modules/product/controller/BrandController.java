package io.renren.modules.product.controller;

import com.rl.product.entity.BPmsCategory;
import com.rl.product.entity.Brand;
import com.rl.product.po.BrandPmsTabData;
import com.rl.product.vo.AddBrand;
import com.rl.product.vo.BrandPms;
import io.renren.common.utils.R;
import io.renren.modules.product.feign.BrandServiceFeign;
import io.renren.modules.product.feign.ProductServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 品牌
 *
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/3 15:34
 */

@RestController
@Slf4j
public class BrandController {

//    @Autowired
//    private BrandServiceFeign brandServiceFeign;

    @Autowired
    private ProductServiceFeign productServiceFeign;


    @PostMapping("/commodity/brand/upload")
    public String upload(@RequestBody MultipartFile picFile){
        String upload = productServiceFeign.upload(picFile);
        return upload;
    }

    //brand品牌查询
    @GetMapping("/commodity/brand")
    public List<Brand> query(){
        List<Brand> query = this.productServiceFeign.query();
        return query;
    }
    //brand品牌查询 根据品牌name查询
    @GetMapping("/commodity/brand/getByBrandName")
    public List<Brand> getByBrandName(com.rl.product.vo.Brand brand){
        List<Brand> byBrandName = this.productServiceFeign.getByBrandName(brand);
        return byBrandName;
    }


    @GetMapping("/commodity/brand/querybyid")
    public Brand queryById(com.rl.product.vo.Brand brand){
        Brand brand1 = this.productServiceFeign.queryById(brand);
        return brand1;
    }

    @PostMapping("/commodity/brand")
    public R add(@RequestBody AddBrand addBrand){
        R add = this.productServiceFeign.add(addBrand);
        return add;
    }

    @PutMapping("/commodity/brand")
    public R edit(@RequestBody com.rl.product.vo.Brand brand){
        R edit = this.productServiceFeign.edit(brand);
        return edit;
    }

    @DeleteMapping("/commodity/brand")
    public R delete(@RequestBody com.rl.product.vo.Brand brand){
        return this.delete(brand);
    }

    /**获取所有的分类*/
    @PostMapping("/commodity/brand/getpmsCategorys")
    public List<BPmsCategory> getBPmsCategorys(){
        return this.productServiceFeign.getBPmsCategorys();
    }

    /**添加关联分类*/
    @PostMapping("/commodity/brand/branPms")
    public R add(@RequestBody BrandPms brandPms){
        return this.add(brandPms);
    }

    @GetMapping("/commodity/brand/branPms")
    public List<BrandPmsTabData> queryBrandPms(BrandPms brandPms){
        return this.productServiceFeign.queryBrandPms(brandPms);
    }
     @DeleteMapping("/commodity/brand/branPms")
    public R deleteBrandPms(@RequestBody BrandPms brandPms){
         return this.productServiceFeign.deleteBrandPms(brandPms);

     }


}
