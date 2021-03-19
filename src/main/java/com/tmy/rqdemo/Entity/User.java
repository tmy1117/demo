package com.tmy.rqdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: muyang.tian
 * @Date: 2021-03-19 14:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /*
     * 姓名
     */
    private String name;
    /*
     * 年龄
     */
    private Integer age;
    /*
     * 手机号
     */
    private Integer phone;

}
