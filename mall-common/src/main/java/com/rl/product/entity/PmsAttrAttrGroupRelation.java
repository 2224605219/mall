package com.rl.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**   组和属性的绑定关联表
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/11 22:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsAttrAttrGroupRelation {

    private Integer id;
    private com.rl.product.entity.PmsAttr pmsAttr;
    private PmsAttrGroup pmsAttrGroup;
    private Integer attrSort;



}
