package com.rl.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/3 20:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddBrand {
    private String t;
    private String name;
    private String log;
    private String introduce;
    private String showstate;
    private String retrieval;
    private String sortlevel;


}
