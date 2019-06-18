package com.javen.testUtil;

import com.javen.model.UsrTable;
import com.javen.util.MapBeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 13:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestUtil {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

   @Test
   public void objToMapTest(){
       UsrTable usrTable = new UsrTable();
       usrTable.setUsrAccount("test");
       usrTable.setUsrPassword("123456");
       usrTable.setUsrName("aaa");
       usrTable.setIsActive(1);
       Map<String, Object> map = MapBeanUtil.objToMap(usrTable);
       System.out.println(map);
       try {
           UsrTable bean = MapBeanUtil.mapToBean(map,UsrTable.class);
           System.out.println(bean);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   @Test
    public void map2BeanTest() throws Exception {
       Map<Object, Object> loginInfo = redisTemplate.opsForHash().entries("loginInfo");
       System.out.println(loginInfo);
       UsrTable usrTable = MapBeanUtil.map2Bean(loginInfo, UsrTable.class);
       System.out.println(usrTable);
   }
}
