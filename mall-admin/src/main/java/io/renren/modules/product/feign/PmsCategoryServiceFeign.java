package io.renren.modules.product.feign;

import com.rl.product.po.Result;
import com.rl.product.vo.DelPmsCategory;
import com.rl.product.vo.PmsCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 17:25
 */
//@FeignClient("mall-product")
public interface PmsCategoryServiceFeign {

    //返回 所有类别 树
    @GetMapping("/commodity/pmsCategory")
    public List<com.rl.product.entity.PmsCategory> returnPmsCategory();

    @PostMapping("/commodity/pmsCategory")
    public Result add(@RequestBody PmsCategory pmsCategory);

    @PutMapping("/commodity/pmsCategory")
    public Result edit(@RequestBody PmsCategory pmsCategory);

    @DeleteMapping("/commodity/pmsCategory")
    public Result delete(@RequestBody PmsCategory pmsCategory);
    /**批量删除*/
    @DeleteMapping("/commodity/pmsCategory/batchdel")
    public Result batchdel(@RequestBody DelPmsCategory delPmsCategory);

}
