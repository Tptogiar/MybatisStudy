package com.service;

import com.dao.UserMapper;
import com.pojo.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/19 - 15:36
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<UserPO> getUsers(){
        UserPO userById = userMapper.getUserById(1);
        ArrayList<UserPO> userPOS = new ArrayList<UserPO>();
        userPOS.add(userById);
        return userPOS;
    }


}
