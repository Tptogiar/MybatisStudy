package com.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 10:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {

    private int id;
    private String name;
    private int age;

}
