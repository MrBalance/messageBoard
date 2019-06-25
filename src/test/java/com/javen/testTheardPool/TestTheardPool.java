package com.javen.testTheardPool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @author: yunzhang.du
 * @description:
 * @Date: 2019-06-17 13:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/springXML/spring.xml"})
public class TestTheardPool {
    private static Logger log= LoggerFactory.getLogger(TestTheardPool.class);
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Test
    public void theadPool(){
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Future<?> future = threadPoolTaskExecutor.submit(() -> runtask(threadPoolTaskExecutor, finalI));
        }

    }
    private void runtask(ThreadPoolTaskExecutor pool,int i){
        System.out.println("线程["+pool.getThreadNamePrefix()+"] : "+i);
        log.info("线程["+pool.getThreadNamePrefix()+"] : "+i);
    }

}
