package com.lzf.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *  任务类
 * @outhor liuzhenfei
 * @create 2017-09-26 下午 4:10
 */
@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTask {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
    public void sayHello(){
        System.out.println("*********************   quartz hello world    *************************");
    }

}
