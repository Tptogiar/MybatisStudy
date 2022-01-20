package dao;

import pojo.po.UserPO;

import java.util.List;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 11:24
 */

public interface UserMapper {

    UserPO getUserById(Integer id);

    List<UserPO> getUsers();

}