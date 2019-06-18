package com.javen.controller;

import com.javen.service.UsrTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 18:23
 */
@Controller
@RequestMapping("/usrTable")
public class UsrTableController {

    private static Logger log= LoggerFactory.getLogger(UsrTableController.class);

    @Autowired
    UsrTableService usrTableService;

    @RequestMapping(value="/login",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam Map<String, Object> map){
        log.info("进入UsrTableController.login()方法");
        String isloginInfo = usrTableService.islogin(map);
        log.info("执行结果：" + isloginInfo);
        return isloginInfo;
    }


}
