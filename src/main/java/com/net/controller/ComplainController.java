package com.net.controller;

import com.net.service.ComplainService;
import com.net.vo.ComplainVO;
import com.net.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cong on 2018-12-12.
 */
@RestController
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    /**
     * 新建投诉
     * @param complainVO
     * @return
     */
    @RequestMapping(value = "/complain/add",method = RequestMethod.POST)
    public ResponseVO addComplain(@RequestBody ComplainVO complainVO){
        return complainService.addComplain(complainVO);
    }

    /**
     * 查询投诉
     * @return
     */
    @RequestMapping(value = "/complain/all",method = RequestMethod.GET)
    public ResponseVO getAllComplains(){
        return complainService.getAllComplains();
    }

}
