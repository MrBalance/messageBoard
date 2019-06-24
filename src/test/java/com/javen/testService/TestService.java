package com.javen.testService;

import com.javen.model.MessageBoardInfo;
import com.javen.service.MessageBoardInfoService;
import com.javen.service.UsrTableService;
import com.javen.service.serviceImpl.UsrTableServiceImpl;
import com.javen.util.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 11:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestService {

    @Autowired
    UsrTableService usrTableService;
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    MessageBoardInfoService messageBoardInfoService;

    @Test
    public void isloginTest(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("account","admin");
        map.put("password","123456");
        String loginInfo = usrTableService.islogin(map);
        System.out.println(loginInfo);
    }

    @Test
    public void leavingMessageTest(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("tittle","testInsert1");
        map.put("key","java1");
        map.put("context","= - =1");
        String result = messageBoardInfoService.leavingMessage(map);
        System.out.println(result);
    }

    @Test
    public void multipleleavingMessageTest(){
        Map<String,Object> map = new HashMap<String, Object>();
        for(int i= 10;i < 20;i ++){
            map.put("tittle","testInsert"+i);
            map.put("key","java"+i);
            map.put("context","= - ="+i);
            String result = messageBoardInfoService.leavingMessage(map);
        }
    }

    @Test
    public void listMessageBoardInfoByPageTest(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("pageNum",1);
        map.put("pageSize",5);
//        map.put("tittle","testInsert");
//        map.put("key","java2");
//        map.put("account","1");
        map.put("context","23");
        PageBean<MessageBoardInfo> pageBean = messageBoardInfoService.listMessageBoardInfoByPage(map);
        List<MessageBoardInfo> messageBoardInfos = pageBean.getRows();
        for (MessageBoardInfo messageBoardInfo : messageBoardInfos) {
            System.out.println(messageBoardInfo);
        }
    }

    @Test
    public void deleteMessagesTest(){
        List<Integer> ids = null;
        ids.add(61);
        ids.add(62);
        ids.add(63);
//        String deleteInfo = (String) messageBoardInfoService.deleteMessages(ids);
//        System.out.println(deleteInfo);
    }


}
