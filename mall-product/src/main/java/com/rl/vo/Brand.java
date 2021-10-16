package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** 品牌
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/3 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {
    private String t;
    private Integer id;
    private String name;
    private String log;
    private String introduce;
    private Integer state;
    private String retrieval;
    private Integer sortlevel;

}
