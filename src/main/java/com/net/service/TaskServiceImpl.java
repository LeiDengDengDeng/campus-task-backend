package com.net.service;

import com.net.enumeration.TaskState;
import com.net.mapper.TaskMapper;
import com.net.vo.CommentVO;
import com.net.vo.ResponseVO;
import com.net.vo.TaskQueryVO;
import com.net.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2018-12-05.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public ResponseVO addTask(TaskVO taskVO) {
        taskVO.setState(TaskState.UNSTART);
        taskMapper.insertSelective(taskVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateTask(TaskVO taskVO) {
        TaskVO taskInDb=taskMapper.selectByPrimaryKey(taskVO.getId());

        if(taskInDb==null)
            return ResponseVO.buildFailure("任务不存在");

        taskMapper.updateByPrimaryKeySelective(taskInDb);

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
        return ResponseVO.buildSuccess();
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
        return ResponseVO.buildSuccess(taskMapper.selectByPublisher(publisherId));
    }

    @Override
    public ResponseVO getTaskByTaker(Integer takerId) {
        return ResponseVO.buildSuccess(taskMapper.selectByTaker(takerId));
    }

    @Override
    public ResponseVO getAllTask(TaskQueryVO taskQueryVO) {
        return ResponseVO.buildSuccess(taskMapper.select(taskQueryVO));
    }
}
