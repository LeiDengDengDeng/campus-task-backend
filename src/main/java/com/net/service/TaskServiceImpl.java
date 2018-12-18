package com.net.service;

import com.net.enumeration.CoinChangeReason;
import com.net.enumeration.TaskState;
import com.net.enumeration.TaskType;
import com.net.mapper.CoinRecordMapper;
import com.net.mapper.TaskMapper;
import com.net.mapper.UserMapper;
import com.net.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2018-12-05.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private CoinRecordMapper coinRecordMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO addTask(TaskVO taskVO) {
        taskVO.setState(TaskState.TO_TAKE_ORDER);
        taskMapper.insertSelective(taskVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateTask(TaskVO taskVO) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(taskVO.getId());

        if(taskInDb==null)
            return ResponseVO.buildFailure("任务不存在");

        taskMapper.updateByPrimaryKeySelective(taskVO);

        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO closeTask(Integer taskId) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(taskId);
        if(taskInDb==null)
            return ResponseVO.buildFailure("任务不存在");
        if(taskInDb.getState()!=TaskState.TO_TAKE_ORDER)
            return ResponseVO.buildFailure("只有未接单的任务才能关闭");
        updateState(taskId,TaskState.CLOSED);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO takeTask(Integer taskId, Integer orderTaker) {
        TaskVO taskVO=new TaskVO();
        taskVO.setId(taskId);
        taskVO.setOrderTaker(orderTaker);
        taskVO.setState(TaskState.ORDER_TAKED);
        taskMapper.updateByPrimaryKeySelective(taskVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO cancelOrder(Integer taskId) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(taskId);
        System.out.println(taskId);
        if(taskInDb==null||taskInDb.getState()!=TaskState.ORDER_TAKED)
            return ResponseVO.buildFailure("只有已接单的订单可以取消,正确状态:"+TaskState.ORDER_TAKED);

        TaskVO taskVO=new TaskVO();
        taskVO.setId(taskId);
        taskVO.setOrderTaker(-1);
        taskVO.setState(TaskState.TO_TAKE_ORDER);
        taskMapper.updateByPrimaryKeySelective(taskVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO finishTask(Integer taskId) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(taskId);
        if(taskInDb==null)
            return ResponseVO.buildFailure("任务不存在");
        if(taskInDb.getState()!=TaskState.ORDER_TAKED)
            return ResponseVO.buildFailure("任务状态不正确");
        updateState(taskId,TaskState.FINISHED);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO confirmFinishTask(Integer taskId) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(taskId);
        if(taskInDb==null)
            return ResponseVO.buildFailure("任务不存在");
        if(taskInDb.getState()!=TaskState.FINISHED)
            return ResponseVO.buildFailure("任务未完成");
        updateState(taskId,TaskState.FINISHED_CONFIRM);
        addCoinRecord(taskInDb);
        return ResponseVO.buildSuccess();
    }

    private void addCoinRecord(TaskVO taskInDb) {
        CoinRecordVO payRecord=new CoinRecordVO();
        payRecord.setReason(CoinChangeReason.PAY_ORDER);
        payRecord.setCount(taskInDb.getPayment());
        payRecord.setUserId(taskInDb.getPublisher());
        payRecord.setTaskId(taskInDb.getId());
        payRecord.setTaskTitle(taskInDb.getTitle());
        coinRecordMapper.insertCoinRecord(payRecord);

        CoinRecordVO rewardRecord=new CoinRecordVO();
        rewardRecord.setTaskTitle(taskInDb.getTitle());
        rewardRecord.setTaskId(taskInDb.getId());
        rewardRecord.setUserId(taskInDb.getOrderTaker());
        rewardRecord.setCount(taskInDb.getPayment());
        rewardRecord.setReason(CoinChangeReason.FINISH_ORDER);
        coinRecordMapper.insertCoinRecord(rewardRecord);
    }

    /**
     * 更新状态
     * @param taskId
     * @param state
     */
    private void updateState(Integer taskId,TaskState state){
        TaskVO updateTask=new TaskVO();
        updateTask.setId(taskId);
        updateTask.setState(state);
        taskMapper.updateByPrimaryKeySelective(updateTask);
    }

    @Override
    public ResponseVO comment(CommentVO commentVO) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(commentVO.getTaskId());
        if(taskInDb==null)
            return ResponseVO.buildFailure("任务不存在");
        Integer star=commentVO.getStar();
        if(star==null||star<1||star>5)
            return ResponseVO.buildFailure("评分只能评一到五星");

        TaskVO taskVO=new TaskVO();
        taskVO.setId(commentVO.getTaskId());
        taskVO.setCommentStar(commentVO.getStar());
        taskVO.setCommentContent(commentVO.getContent());
        taskMapper.updateByPrimaryKeySelective(taskVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getTaskByPublisher(Integer publisherId) {
        TaskShowVO taskShowVO=new TaskShowVO();
        taskShowVO.setTasks(taskMapper.selectByPublisher(publisherId));
        taskShowVO.setUserVO(userMapper.selectUserInfoById(publisherId));
        return ResponseVO.buildSuccess(taskShowVO);
    }

    @Override
    public ResponseVO getTaskByTaker(Integer takerId) {
        TaskShowVO taskShowVO=new TaskShowVO();
        taskShowVO.setTasks(taskMapper.selectByTaker(takerId));
        taskShowVO.setUserVO(userMapper.selectUserInfoById(takerId));
        return ResponseVO.buildSuccess(taskShowVO);
    }

    @Override
    public ResponseVO getTaskByTime() {
        return ResponseVO.buildSuccess(taskMapper.selectByTime());
    }

    @Override
    public ResponseVO getTaskByType(TaskType type) {
        return ResponseVO.buildSuccess(taskMapper.selectByType(type));
    }

    @Override
    public ResponseVO getTaskByPayment() {
        return ResponseVO.buildSuccess(taskMapper.selectByPayment());
    }

    @Override
    public ResponseVO getTaskById(Integer taskId) {
        return ResponseVO.buildSuccess(taskMapper.selectByPrimaryKey(taskId));
    }

}
