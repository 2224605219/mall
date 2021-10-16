package com.rl.product.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**  关联分类表数据
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/7 21:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BrandPmsTabData {
    private Integer id;
    private String brandName;
    private String pmsName;
}
