package com.controller;

import com.pojo.po.UserPO;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/19 - 14:21
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public String getUsers(Model model){
        List<UserPO> users = userService.getUsers();
        model.addAttribute("users",users);
        return "userList";
    }

}
