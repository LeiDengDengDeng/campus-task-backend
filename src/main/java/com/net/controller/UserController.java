package com.net.controller;

import com.net.service.UserService;
import com.net.vo.ResponseVO;
import com.net.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fjj
 * @date 2018/12/11 下午7:59
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="user/add",method = RequestMethod.POST)
    public ResponseVO addUser(@RequestBody UserVO userVO){
        return userService.addUser(userVO);
    }

}
