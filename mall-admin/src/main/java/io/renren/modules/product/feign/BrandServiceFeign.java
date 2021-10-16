package io.renren.modules.product.feign;

import com.rl.product.entity.BPmsCategory;
import com.rl.product.entity.Brand;
import com.rl.product.po.BrandPmsTabData;
import com.rl.product.vo.AddBrand;
import com.rl.product.vo.BrandPms;
import io.renren.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
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

//@FeignClient("mall-product")
public interface BrandServiceFeign {


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



}
