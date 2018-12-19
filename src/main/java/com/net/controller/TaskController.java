package com.net.controller;

import com.net.enumeration.TaskType;
import com.net.service.TaskService;
import com.net.vo.CommentVO;
import com.net.vo.ResponseVO;
import com.net.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2018-12-06.
 */
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 新建任务
     * @param taskVO
     * @return
     */
    @RequestMapping(value = "/task/add",method = RequestMethod.POST)
    public ResponseVO addTask(@RequestBody TaskVO taskVO){
        return taskService.addTask(taskVO);
    }

    /**
     * 修改任务
     * 在接单开始时间之前
     * @param taskVO
     * @return
     */
    @RequestMapping(value = "/task/update",method = RequestMethod.POST)
    public ResponseVO updateTask(@RequestBody TaskVO taskVO){
        return taskService.updateTask(taskVO);
    }



    /**
     * 关闭任务
     * 在接单开始之前
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/task/close/{taskId}",method = RequestMethod.POST)
    public ResponseVO closeTask(@PathVariable Integer taskId){
        return taskService.closeTask(taskId);
    }

    /**
     * 接单人完成任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/task/finish/{taskId}",method = RequestMethod.POST)
    public ResponseVO finishTask(@PathVariable Integer taskId){
        return taskService.finishTask(taskId);
    }

    /**
     * 发布人确认完成任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/task/confirm/{taskId}",method = RequestMethod.POST)
    public ResponseVO confirmFinishTask(@PathVariable Integer taskId){
        return taskService.confirmFinishTask(taskId);
    }

    /**
     * 评论
     * @param commentVO
     * @return
     */
    @RequestMapping(value = "/task/comment/add",method = RequestMethod.POST)
    public ResponseVO comment(@RequestBody CommentVO commentVO){
        return taskService.comment(commentVO);
    }

    /**
     * 根据发布人查询任务
     * @param publisherId
     * @return
     */
    @RequestMapping(value = "/task/publisher/{publisherId}",method = RequestMethod.GET)
    public ResponseVO getTaskByPublisher(@PathVariable Integer publisherId){
        return taskService.getTaskByPublisher(publisherId);
    }

    /**
     * 根据接单人查询任务
     * @param takerId
     * @return
     */
    @RequestMapping(value = "/task/taker/{takerId}",method = RequestMethod.GET)
    public ResponseVO getTaskByTaker(@PathVariable Integer takerId){
        return taskService.getTaskByTaker(takerId);
    }

    /**
     * 根据时间排序
     * @return
     */
    @RequestMapping(value = "/task/time",method = RequestMethod.GET)
    public ResponseVO getTaskByTime(){
        return taskService.getTaskByTime();
    }

    /**
     * 根据类型筛选
     * @return
     */
    @RequestMapping(value = "/task/type/{taskType}",method = RequestMethod.GET)
    public ResponseVO getTaskByType(@PathVariable TaskType taskType){
        return taskService.getTaskByType(taskType);
    }

    /**
     * 根据报酬排序
     * @return
     */
    @RequestMapping(value = "/task/payment",method = RequestMethod.GET)
    public ResponseVO getTaskByPayment(){
        return taskService.getTaskByPayment();
    }

    /**
     * 根据id查询任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/task/id/{taskId}",method = RequestMethod.GET)
    public ResponseVO getTaskById(@PathVariable Integer taskId){
        return taskService.getTaskById(taskId);
    }


    /**
     * 接单
     * @param taskId
     * @param orderTaker
     * @return
     */
    @RequestMapping(value = "/task/take/{taskId}/{orderTaker}",method = RequestMethod.GET)
    public ResponseVO takeTask(@PathVariable Integer taskId,@PathVariable Integer orderTaker){
        return taskService.takeTask(taskId,orderTaker);
    }

    /**
     * 取消已接任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/task/cancel/{taskId}",method = RequestMethod.POST)
    public ResponseVO cancelOrder(@PathVariable Integer taskId){
        return taskService.cancelOrder(taskId);
    }


}
