package com.rl.product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**  品牌和分类关系表
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/6 10:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BrandPms {
    private Integer id;
    private Brand brand;
    private PmsCategory pmsCategory;

}
