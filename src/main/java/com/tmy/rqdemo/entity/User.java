package com.tmy.rqdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @author: muyang.tian
 * @Date: 2021-03-19 14:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /*
     * id
     */
    private Integer id;
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
    private String phone;
    /*
     * 邮箱
     */
    private String email;
    /*
     * 创建时间
     */
    private Date create_at;


}
