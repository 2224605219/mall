package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/2 17:02
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PmsCategory {
    private String t;
    private String name;
    private Integer id;
}
