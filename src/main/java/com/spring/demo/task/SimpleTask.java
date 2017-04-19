package com.spring.demo.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class SimpleTask extends TaskBase{
	
	 //每5秒钟执行一次
    @Scheduled(cron = "*/5 * *  * * * ")
    public void reportCurrentByCron(){
    	LOG.info("Task start 每5秒钟执行一次");
    }

}
