package com.javen.service;

import com.javen.model.MessageBoardInfo;
import com.javen.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author: 杜云章
 * @description: 留言业务处理
 * @Date: 2019-06-11 12:49
 */
public interface MessageBoardInfoService {

     /**
      * @Author: 杜云章
      * @description: 留言功能
      * @parm: map[title,key,context]
      * @return: String 返回异常文字描述，0表示正常
      * @Date: 2019/6/11 - 12:53
      */
    public String leavingMessage(Map<String,Object> map);



     /**
      * @Author: 杜云章
      * @description: 分页查询
      * @parm: map[pageNum,pageSize, ...(待查询的条件)]
      * @return: List<MessageBoardInfo>
      * @Date: 2019/6/11 - 15:48
      */
    public PageBean<MessageBoardInfo> listMessageBoardInfoByPage(Map<String,Object> map);


    /**
     * @Author: 杜云章
     * @description: 删除留言
     * @parm: List<MessageBoardInfo> list
     * @return: String 返回异常文字描述，0表示正常
     * @Date: 2019/6/11 - 17:40
     */
    public String deleteMessages(List<Integer> list);

}
