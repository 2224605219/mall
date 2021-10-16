package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/2 22:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DelPmsCategory {
    private String t;
    private int[] checkdNodes;

}
