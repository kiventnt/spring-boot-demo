package com.spring.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Service 基础父类
 * @author HuangKai
 */
public class ServiceBase {

	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected StringRedisTemplate stringRedisTemplate;
	
}
