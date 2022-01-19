package com.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 10:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class UserPO {

    private int id;
    private String lastName;
    private int age;

}
