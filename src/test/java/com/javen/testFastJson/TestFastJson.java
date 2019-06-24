package com.javen.testFastJson;

import com.alibaba.fastjson.JSONObject;
import com.javen.model.MessageBoardInfo;
import com.javen.service.MessageBoardInfoService;
import com.javen.util.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-12 16:05
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestFastJson {

    @Autowired
    MessageBoardInfoService messageBoardInfoService;

    @Test
    public void testFastJson(){
        Map< String , Object > map = new HashMap< String , Object>();
        map.put("pageNum",1);
        map.put("pageSize",10);
        PageBean<MessageBoardInfo> searchResult = messageBoardInfoService.listMessageBoardInfoByPage(map);
        System.out.println(searchResult.toString());
        System.out.println("--------------------------------------------------------------");
        String str = JSONObject.toJSONString(searchResult);
        System.out.println(str);
    }
}
