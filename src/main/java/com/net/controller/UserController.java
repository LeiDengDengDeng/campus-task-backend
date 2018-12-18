package com.net.controller;

import com.net.enumeration.UserState;
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

    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    public ResponseVO getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/state/{state}",method = RequestMethod.GET)
    public ResponseVO getUsersByState(@PathVariable String state){
        return userService.getUsersByState(state);
    }

    @RequestMapping(value = "/user/{id}/coins",method = RequestMethod.GET)
    public ResponseVO getCoinsByUserId(@PathVariable int id){
        return userService.getCoinsByUserId(id);
    }

    /**
     * 发单详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}/task/publish",method = RequestMethod.GET)
    public ResponseVO getPublicByUserId(@PathVariable int id){
        return userService.getPublicByUserId(id);
    }

    /**
     * 接单详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}/task/take",method = RequestMethod.GET)
    public ResponseVO getTakeByUserId(@PathVariable int id){
        return userService.getTakeByUserId(id);
    }



}
