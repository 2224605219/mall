package com.rl.controller;

import com.rl.entity.BPmsCategory;
import com.rl.po.BrandPmsTabData;
import com.rl.service.BPmsCategoryService;
import com.rl.service.BrandPmsService;
import com.rl.service.BrandService;
import com.rl.util.FastDFSUtils;
import com.rl.util.R;
import com.rl.vo.AddBrand;
import com.rl.vo.Brand;
import com.rl.vo.BrandPms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandPmsService brandPmsService;

    @PostMapping("/commodity/brand/upload")
    public String upload(@RequestBody MultipartFile picFile){
        log.info(""+picFile);
        try {
            //获取文件源
            byte[] uploadBytes = picFile.getBytes();

            //获取文件后缀名
            String originalFilename = picFile.getOriginalFilename();
            String exName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            //调用自定义工具类完成文件上传工作 并返回上传到fastDFS的文件地址
            String path = FastDFSUtils.upload(uploadBytes, exName);
            System.out.println("------------------>" + path);
            log.info("=========-=-=-=-=-=--=-=-=-===>http://192.168.79.10:8080/"+path);
            return "http://192.168.79.10:8080/" + path;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //brand品牌查询
    @GetMapping("/commodity/brand")
    public List<com.rl.entity.Brand> query(){
        log.info("1111111111111111111111111");
        List<com.rl.entity.Brand> brands = this.brandService.queryAll();
        log.info("2222222222222222222222222");
        log.info("===================>"+brands);
        return brands;
    }
    //brand品牌查询 根据品牌name查询
    @GetMapping("/commodity/brand/getByBrandName")
    public List<com.rl.entity.Brand> getByBrandName(Brand brand){
        log.info("1111111111111111111111111"+brand);
        List<com.rl.entity.Brand> brands = this.brandService.queryAll();
        log.info("===================>"+brands);
        return brands;
    }


    @GetMapping("/commodity/brand/querybyid")
    public com.rl.entity.Brand queryById(Brand brand){
        com.rl.entity.Brand result = this.brandService.getById(brand.getId());
        return result;
    }

    @PostMapping("/commodity/brand")
    public R add(@RequestBody AddBrand addBrand){
        log.info("----------------------------->"+addBrand);
        this.brandService.add(new com.rl.entity.Brand(-1, addBrand.getName(), addBrand.getLog(), addBrand.getIntroduce(),1, addBrand.getRetrieval(),Integer.parseInt(addBrand.getSortlevel()),"true".equals(addBrand.getShowstate())?1:0));
        return R.ok().put("200","ok");
    }

    @PutMapping("/commodity/brand")
    public R edit(@RequestBody Brand brand){
        this.brandService.update(new com.rl.entity.Brand(brand.getId(), brand.getName(), brand.getLog(), brand.getIntroduce(), brand.getState(), brand.getRetrieval(),brand.getSortlevel(), brand.getState()));
        return R.ok().put("200","ok").put("msg","修改成功！");
    }

    @DeleteMapping("/commodity/brand")
    public R delete(@RequestBody Brand brand){
        try {
            this.brandService.delete(brand.getId());
            return R.ok().put("code","200").put("msg","删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return R.ok().put("code","500").put("msg","删除失败！");
        }
    }

    @Autowired
    private BPmsCategoryService bPmsCategoryService;
    /**获取所有的分类*/
    @PostMapping("/commodity/brand/getpmsCategorys")
    public List<BPmsCategory> getBPmsCategorys(){
        List<BPmsCategory> bPmsCategory = this.bPmsCategoryService.getBPmsCategory();

        return bPmsCategory;
    }

    /**添加关联分类*/
    @PostMapping("/commodity/brand/branPms")
    public R add(@RequestBody BrandPms brandPms){
        log.info("--------------111111111111111111111111111111--------------->"+brandPms);
        Integer pmsId = this.bPmsCategoryService.getByName(brandPms.getPmsName());
        this.brandPmsService.add(brandPms.getBrandId(),pmsId);
        return R.ok().put("code",200).put("msg","添加成功");
    }

    @GetMapping("/commodity/brand/branPms")
    public List<BrandPmsTabData> queryBrandPms(BrandPms brandPms){
        log.info("0000000000000000000000000000000000000000000000ln0");
        log.info("----------------------------->"+brandPms);
        List<com.rl.entity.BrandPms> brandPmsList = this.brandPmsService.getByBrandId(brandPms.getBrandId());
        log.info("_______________________________>"+brandPmsList);
        ArrayList<BrandPmsTabData> brandPmsTabData = new ArrayList<>();
        for (com.rl.entity.BrandPms  bP:brandPmsList)
            brandPmsTabData.add(new BrandPmsTabData(bP.getId(),bP.getBrand().getName(),bP.getPmsCategory().getLabel()));
        return brandPmsTabData;
    }
     @DeleteMapping("/commodity/brand/branPms")
    public R deleteBrandPms(@RequestBody BrandPms brandPms){
        log.info("----------------------------->"+brandPms);
        this.brandPmsService.delete(brandPms.getId());
        return R.ok().put("code",200).put("msg","删除成功！");
    }






}
