package com.rl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/7 20:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BrandPms {
    private String t;
    private Integer id;
    private Integer pmsId;
    private Integer brandId;
    private String pmsName;

}
