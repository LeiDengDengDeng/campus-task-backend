package com.net.controller;

import com.net.service.UserService;
import com.net.vo.ResponseVO;
import com.net.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fjj
 * @date 2018/12/11 下午7:59
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/add",method = RequestMethod.POST)
    public ResponseVO addUser(@RequestBody UserVO userVO){
        return userService.addUser(userVO);
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody UserVO userVO){return userService.updateUser(userVO);}

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable int id){
        return userService.getUser(id);
    }

}
