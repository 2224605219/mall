package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/12 16:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsAttrAttrGroupRelation {
    public int[] ids; //所有的id
    private Integer attrGroupId;//组的id
    public int[] pmsAttrIds;//用于批量增加
}
