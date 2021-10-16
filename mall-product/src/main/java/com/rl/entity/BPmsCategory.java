package com.rl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**  商品分类 用于在品牌和分类的绑定
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/6 22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BPmsCategory {

    private Integer value;
    private String label;
    private List<BPmsCategory> children;

}
