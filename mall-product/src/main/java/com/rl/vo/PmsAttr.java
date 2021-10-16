package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**   属性entity
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/10 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsAttr {

    private Integer attrId;  //属性id
    private String attrName;  //属性名
    private boolean searchType;  //是否需要检索[0-不需要，1-需要]
    private String icon;  //属性图标
    private String valueSelect;  //可选值列表[用逗号分隔]
    private Integer attrType;  //属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
    private boolean enable;  //启用状态[0 - 禁用，1 - 启用]
    private Integer catelogId;  //所属分类
    private boolean showDesc;  //快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
    private boolean valueType; //值类型[0-为单个值，1-可以选择多个值]
    private Integer[] attrIds;//根据该ids批量删除
    private Integer groupId; //组id


}
