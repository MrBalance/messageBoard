package com.javen.controller;

import com.alibaba.fastjson.JSONObject;
import com.javen.model.MessageBoardInfo;
import com.javen.service.MessageBoardInfoService;
import com.javen.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-12 9:51
 */
@Controller
@RequestMapping("/MessageBoardInfo")
public class MessageBoardInfoController {

    private static Logger log= LoggerFactory.getLogger(UsrTableController.class);

    @Autowired
    MessageBoardInfoService messageBoardInfoService;

    @RequestMapping(value="/searchMessage",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam Map<String, Object> map){
        log.info("MessageBoardInfo.searchMessage()方法");
        PageBean<MessageBoardInfo> searchResult = messageBoardInfoService.listMessageBoardInfoByPage(map);
        log.info("执行结果：" + JSONObject.toJSONString(searchResult));
        return JSONObject.toJSONString(searchResult);
    }

    @RequestMapping(value="/leavingMessage",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String leavingMessage(@RequestParam Map<String, Object> map){
        log.info("MessageBoardInfo.leavingMessage()方法");
        String searchResult = messageBoardInfoService.leavingMessage(map);
        log.info("执行结果：" + searchResult);
        return searchResult;
    }

    @RequestMapping(value="/deleteMessages",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String deleteMessages(@RequestParam("list[]") List<Integer> list){
        log.info("MessageBoardInfo.deleteMessages()方法");
        String searchResult = messageBoardInfoService.deleteMessages(list);
        log.info("执行结果：" + searchResult);
        return searchResult;
    }
}

