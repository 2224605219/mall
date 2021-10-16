package com.rl.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 21:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {
    private Integer code;
    private String msg;
}
