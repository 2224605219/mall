package io.renren.modules.product.controller;

import com.rl.product.po.Result;
import com.rl.product.vo.DelPmsCategory;
import com.rl.product.vo.PmsCategory;
import io.renren.modules.product.feign.PmsCategoryServiceFeign;
import io.renren.modules.product.feign.ProductServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 17:25
 */
@RestController
@Slf4j
public class PmsCategoryController {

//    @Autowired
//    private PmsCategoryServiceFeign pmsCategoryServiceFeign;


    @Autowired
    private ProductServiceFeign productServiceFeign;

    //返回 所有类别 树
    @GetMapping("/commodity/pmsCategory")
    public List<com.rl.product.entity.PmsCategory> returnPmsCategory(){
        return this.productServiceFeign.returnPmsCategory1();
    }

    @PostMapping("/commodity/pmsCategory")
    public Result add(@RequestBody PmsCategory pmsCategory){
        return this.productServiceFeign.add(pmsCategory);
    }

    @PutMapping("/commodity/pmsCategory")
    public Result edit(@RequestBody PmsCategory pmsCategory){
        return this.productServiceFeign.edit(pmsCategory);
    }

    @DeleteMapping("/commodity/pmsCategory")
    public Result delete(@RequestBody PmsCategory pmsCategory){
        return this.productServiceFeign.delete(pmsCategory);
    }
    /**批量删除*/
    @DeleteMapping("/commodity/pmsCategory/batchdel")
    public Result batchdel(@RequestBody DelPmsCategory delPmsCategory){
        return this.productServiceFeign.batchdel(delPmsCategory);
    }


}
