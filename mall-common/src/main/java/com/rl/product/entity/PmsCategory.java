package com.rl.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/1 16:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsCategory {
    private Integer id;
    private String label;
    private Integer parentCid;
    private List<PmsCategory> children;

}
