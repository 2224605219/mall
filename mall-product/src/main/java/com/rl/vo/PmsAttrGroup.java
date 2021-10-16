package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**   属性 - 组
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/9 18:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsAttrGroup {

    private Integer attrGroupId;
    private String attrGroupName;
    private Integer sort; //排序
    private String descript;//描述
    private String icon;//组图标
    private Integer catelogId;//分类id
    private Integer[]  attrGroupIds;//用于批量删除


}
