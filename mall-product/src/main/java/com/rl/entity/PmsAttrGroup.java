package com.rl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("pms_attr_group")
public class PmsAttrGroup {

    @TableId(value = "attr_group_id",type = IdType.AUTO)//主键,设置自增
    private Integer attrGroupId;
    private String attrGroupName;
    private Integer sort; //排序
    private String descript;//描述
    private String icon;//组图标
    private Integer catelogId;//分类id

}
